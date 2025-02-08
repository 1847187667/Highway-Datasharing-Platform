<template>
  <div class="data-screen-container">
    <div class="screen-header">
      <h2>高速公路数据监控中心</h2>
      <div class="header-right">
        <span class="time">{{ currentTime }}</span>
      </div>
    </div>

    <div class="screen-content">
      <el-row :gutter="20">
        <!-- 左侧折线图区域 -->
        <el-col :span="14">
          <el-row>
            <el-col :span="24">
              <div class="chart-panel">
                <div class="chart-container" ref="trafficChart"></div>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <div class="chart-panel">
                <div class="chart-container" ref="speedChart"></div>
              </div>
            </el-col>
          </el-row>
        </el-col>

        <!-- 右侧图表区域 -->
        <el-col :span="10">
          <el-row>
            <el-col :span="24">
              <div class="chart-panel vehicle-type">
                <div class="chart-container" ref="vehicleTypeChart"></div>
              </div>
            </el-col>
          </el-row>
          <el-row :gutter="10">
            <el-col :span="12">
              <div class="chart-panel radar">
                <div class="chart-container" ref="accidentRadarChart"></div>
              </div>
            </el-col>
            <el-col :span="12">
              <div class="chart-panel radar">
                <div class="chart-container" ref="controlRadarChart"></div>
              </div>
            </el-col>
          </el-row>
          <el-row :gutter="10">
            <el-col :span="12">
              <div class="chart-panel radar">
                <div class="chart-container" ref="maintenanceRadarChart"></div>
              </div>
            </el-col>
            <el-col :span="12">
              <div class="chart-panel radar">
                <div class="chart-container" ref="emergencyRadarChart"></div>
              </div>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import * as echarts from 'echarts'
import { getTrafficDashboardData, getLatestTrafficStatus } from '@/api/system/datascreen'

export default {
  name: 'DataScreen',
  data() {
    return {
      currentTime: '',
      timer: null,
      trafficData: null,
      latestStatus: null,
      charts: {
        trafficChart: null,
        speedChart: null,
        vehicleTypeChart: null,
        accidentRadarChart: null,
        controlRadarChart: null,
        maintenanceRadarChart: null,
        emergencyRadarChart: null
      }
    }
  },
  mounted() {
    this.initTime()
    this.$nextTick(() => {
      this.initCharts()
      this.fetchData()
      // 添加窗口大小变化监听
      window.addEventListener('resize', this.handleResize)
      // 定时刷新数据
      this.timer = setInterval(() => {
        this.fetchData()
      }, 60000)
    })
  },
  beforeDestroy() {
    if (this.timer) {
      clearInterval(this.timer)
    }
    // 移除窗口大小变化监听
    window.removeEventListener('resize', this.handleResize)
    // 销毁图表实例
    Object.values(this.charts).forEach(chart => {
      chart && chart.dispose()
    })
  },
  methods: {
    initTime() {
      this.updateTime()
      this.timer = setInterval(this.updateTime, 1000)
    },
    updateTime() {
      this.currentTime = new Date().toLocaleString()
    },
    async fetchData() {
      try {
        const dashboardRes = await getTrafficDashboardData()
        if (dashboardRes.code === 200) {
          this.trafficData = dashboardRes.data

          // 确保数据格式正确
          if (!Array.isArray(this.trafficData.accidentStats)) {
            console.error('Accident stats data is not an array');
            return;
          }

          this.updateCharts()
        }

        // 获取最新状态
        const latestRes = await getLatestTrafficStatus()
        if (latestRes.code === 200) {
          this.latestStatus = latestRes.data
        }
      } catch (error) {
        console.error('获取数据失败:', error)
        this.$message.error('获取数据失败')
      }
    },
    initCharts() {
      // 确保容器存在
      if (!this.$refs.trafficChart) {
        console.error('Chart container not found')
        return
      }
      if (!this.$refs.speedChart) {
        console.error('Chart container not found')
        return
      }
      if (!this.$refs.vehicleTypeChart) {
        console.error('Chart container not found')
        return
      }
      if (!this.$refs.accidentRadarChart) {
        console.error('Accident radar chart container not found')
        return
      }
      if (!this.$refs.controlRadarChart) {
        console.error('Chart container not found')
        return
      }
      if (!this.$refs.maintenanceRadarChart) {
        console.error('Chart container not found')
        return
      }
      if (!this.$refs.emergencyRadarChart) {
        console.error('Chart container not found')
        return
      }

      // 初始化所有图表
      const chartRefs = {
        trafficChart: this.$refs.trafficChart,
        speedChart: this.$refs.speedChart,
        vehicleTypeChart: this.$refs.vehicleTypeChart,
        accidentRadarChart: this.$refs.accidentRadarChart,
        controlRadarChart: this.$refs.controlRadarChart,
        maintenanceRadarChart: this.$refs.maintenanceRadarChart,
        emergencyRadarChart: this.$refs.emergencyRadarChart
      }

      // 遍历初始化每个图表
      Object.entries(chartRefs).forEach(([key, el]) => {
        if (el) {
          this.charts[key] = echarts.init(el)
        } else {
          console.error(`Container for ${key} not found`)
        }
      })
    },
    updateCharts() {
      if (!this.trafficData) {
        console.error('No traffic data available');
        return;
      }

      // 更新雷达图
      const radarCharts = [
        {
          name: 'accidentRadarChart',
          title: '事故类型分布',
          data: this.trafficData.accidentStats,
          color: 'rgb(0, 255, 255)'
        },
        {
          name: 'controlRadarChart',
          title: '交通管制原因',
          data: this.trafficData.controlStats,
          color: 'rgb(255, 165, 0)'
        },
        {
          name: 'maintenanceRadarChart',
          title: '维护施工类型',
          data: this.trafficData.maintenanceStats,
          color: 'rgb(0, 255, 0)'
        },
        {
          name: 'emergencyRadarChart',
          title: '紧急事件类型',
          data: this.trafficData.emergencyStats,
          color: 'rgb(255, 0, 0)'
        }
      ];

      // 更新每个雷达图
      radarCharts.forEach(chart => {
        if (this.charts[chart.name] && Array.isArray(chart.data) && chart.data.length > 0) {
          const option = this.createRadarOption(chart.title, chart.data, chart.color);
          if (option) {
            this.charts[chart.name].setOption(option, true);
          }
        } else {
          console.error(`Data for ${chart.name} is invalid or empty`);
        }
      });

      // 更新交通流量图表
      this.charts.trafficChart.setOption({
        title: {
          text: '交通流量趋势',
          textStyle: {
            color: '#fff',
            fontSize: 16,
            fontWeight: 'bold'
          },
          left: 'center',
          top: 0
        },
        tooltip: {
          trigger: 'axis',
          formatter: function(params) {
            return `${params[0].axisValue}<br/>流量: ${params[0].value}辆/小时`;
          }
        },
        grid: {
          top: '30px',
          left: '3%',
          right: '3%',
          bottom: '8%',
          containLabel: true
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: this.trafficData.latestData.map(item => item.time),
          axisLabel: {
            color: '#fff',
            rotate: 35,
            interval: 0,
            margin: 6,
            fontSize: 11
          }
        },
        yAxis: {
          type: 'value',
          name: '流量(辆/小时)',
          nameTextStyle: {
            color: '#fff',
            padding: [0, 30, 0, 0]
          },
          axisLabel: {
            color: '#fff',
            margin: 8
          },
          splitLine: {
            lineStyle: { color: 'rgba(255,255,255,0.1)' }
          }
        },
        series: [{
          name: '交通流量',
          type: 'line',
          smooth: true,
          symbol: 'circle',
          symbolSize: 8,
          data: this.trafficData.latestData.map(item => parseInt(item.volume)),
          areaStyle: {
            opacity: 0.3,
            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
              { offset: 0, color: 'rgba(0,255,255,0.3)' },
              { offset: 1, color: 'rgba(0,255,255,0.1)' }
            ])
          },
          itemStyle: {
            color: '#00ffff',
            borderWidth: 2
          },
          lineStyle: {
            width: 3
          }
        }]
      });

      // 更新平均速度趋势图
      this.charts.speedChart.setOption({
        title: {
          text: '平均速度趋势',
          textStyle: {
            color: '#fff',
            fontSize: 16,
            fontWeight: 'bold'
          },
          left: 'center',
          top: 0
        },
        tooltip: {
          trigger: 'axis',
          formatter: function(params) {
            const item = params[0];
            return `${item.name}<br/>速度: ${item.value}km/h<br/>状态: ${item.data.status}`;
          }
        },
        grid: {
          top: '30px',
          left: '3%',
          right: '3%',
          bottom: '8%',
          containLabel: true
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: this.trafficData.latestData.map(item => item.time),
          axisLabel: {
            color: '#fff',
            rotate: 35,
            interval: 0,
            margin: 6,
            fontSize: 11
          }
        },
        yAxis: {
          type: 'value',
          name: '速度(km/h)',
          nameTextStyle: { color: '#fff' },
          axisLabel: { color: '#fff' },
          splitLine: {
            lineStyle: { color: 'rgba(255,255,255,0.1)' }
          }
        },
        series: [{
          name: '平均速度',
          type: 'line',
          smooth: true,
          symbol: 'circle',
          symbolSize: 8,
          data: this.trafficData.latestData.map(item => ({
            value: item.speed,
            status: item.status
          })),
          itemStyle: {
            color: '#00ff00',
            borderWidth: 2
          },
          lineStyle: {
            width: 3
          }
        }]
      });

      // 修改车型分布堆叠柱状图的配置
      const vehicleTypes = ['小型车', '中型车', '大型车', '特大型车'];
      const series = vehicleTypes.map(type => ({
        name: type,
        type: 'bar',
        stack: 'total',
        barWidth: '40%',
        emphasis: {
          focus: 'series'
        },
        itemStyle: {
          color: this.getVehicleTypeColor(type)
        },
        data: this.trafficData.latestData.map(item => item[type] || 0)
      }));

      this.charts.vehicleTypeChart.setOption({
        title: {
          text: '车型分布趋势',
          textStyle: {
            color: '#fff',
            fontSize: 16,
            fontWeight: 'bold'
          },
          left: 'center',
          top: 0
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: { type: 'shadow' },
          formatter: (params) => {
            let result = `${params[0].axisValue}<br/>`;
            let total = 0;
            params.forEach(param => {
              const value = param.value || 0;
              total += value;
              result += `${param.seriesName}: ${value}%<br/>`;
            });
            result += `总计: ${total}%`;
            return result;
          }
        },
        legend: {
          data: vehicleTypes,
          textStyle: { color: '#fff' },
          top: '30px',
          left: 'center',
          itemGap: 15
        },
        grid: {
          top: '80px',
          left: '3%',
          right: '3%',
          bottom: '8%',
          containLabel: true
        },
        xAxis: {
          type: 'category',
          data: this.trafficData.latestData.map(item => item.time),
          axisLabel: {
            color: '#fff',
            rotate: 35,
            interval: 0,
            margin: 6,
            fontSize: 11,
            overflow: 'break'
          }
        },
        yAxis: {
          type: 'value',
          name: '车辆分布(%)',
          nameTextStyle: {
            color: '#fff',
            padding: [0, 30, 0, 0]
          },
          axisLabel: {
            color: '#fff',
            margin: 8,
            formatter: '{value}%'
          },
          splitLine: {
            lineStyle: { color: 'rgba(255,255,255,0.1)' }
          }
        },
        series: series
      });
    },
    getVehicleTypeColor(type) {
      const colors = {
        '小型车': '#00ffff',
        '中型车': '#00ff00',
        '大型车': '#ff00ff',
        '特大型车': '#ffff00'
      };
      return colors[type] || '#fff';
    },
    // 添加处理窗口大小变化的方法
    handleResize() {
      Object.values(this.charts).forEach(chart => {
        chart && chart.resize()
      })
    },
    // 修改雷达图的配置生成方法
    createRadarOption(title, data, color) {
      if (!data || !Array.isArray(data)||data.length === 0) {
        console.error('Invalid data for radar chart:', title)
        return null
      }

      const indicators = data.map(item => ({
        name: item.type,
        max: Math.max(...data.map(s => s.value)) * 1.2 || 100
      }))

      return {
        title: {
          text: title,
          textStyle: {
            color: '#fff',
            fontSize: 16,
            fontWeight: 'bold'
          },
          left: '5px',
          top: '5px'
        },
        tooltip: {
          trigger: 'item'
        },
        radar: {
          indicator: indicators,
          center: ['55%', '54%'],
          radius: '65%',
          shape: 'circle',
          splitNumber: 4,
          name: {
            textStyle: {
              color: '#fff',
              fontSize: 12,
            }
          },
          axisLine: {
            lineStyle: {
              color: 'rgba(255,255,255,0.2)'
            }
          },
          splitLine: {
            lineStyle: {
              color: 'rgba(255,255,255,0.2)'
            }
          },
          splitArea: {
            show: true,
            areaStyle: {
              color: ['rgba(255,255,255,0.05)', 'rgba(255,255,255,0.1)']
            }
          }
        },
        series: [{
          type: 'radar',
          data: [{
            value: data.map(item => item.value),
            name: title,
            symbol: 'circle',
            symbolSize: 4,
            lineStyle: {
              color: color,
              width: 2
            },
            areaStyle: {
              color: color.replace(')', ', 0.3)')
            },
            itemStyle: {
              color: color
            }
          }]
        }]
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.data-screen-container {
  width: 100%;
  height: 100vh;
  background: #0f1c3c;
  color: #fff;
  padding: 5px 20px;
  box-sizing: border-box;
  overflow: hidden;  // 防止出现滚动条

  .screen-header {
    height: 40px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-top: 5px;

    h2 {
      font-size: 24px;
      color: #fff;
      margin: 0;
    }

    .time {
      font-size: 18px;
      color: #00ffff;
    }
  }

  .screen-content {
    height: calc(100vh - 100px);
    padding: 10px 0;

    .el-row {
      margin-bottom: 10px;
      &:last-child {
        margin-bottom: 0;
      }
    }

    .chart-panel {
      background: rgba(255, 255, 255, 0.05);
      border-radius: 4px;
      padding: 8px;
      height: calc((100vh - 140px) / 2);

      &.vehicle-type {
        .chart-container {
          padding: 0 5px;
        }
      }

      &.radar {
        height: calc((100vh - 160px) / 4);
        padding: 5px;

        .chart-container {
          height: 100%;
          min-height: 180px;
        }
      }

      .chart-container {
        height: 100%;
        width: 100%;
      }
    }
  }
}

// 响应式调整
@media screen and (max-height: 900px) {
  .data-screen-container {
    .screen-content {
      .chart-panel {
        &.radar {
          .chart-container {
            min-height: 160px;
          }
        }
      }
    }
  }
}
</style>
