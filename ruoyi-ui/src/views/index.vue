<template>
  <div class="app-container home" :style="backgroundStyle">
    <div class="content-wrapper" style="margin-top: 5px; padding-top: 5px;">
      <!-- 系统标题 -->
      <div class="system-title">
        <h1 style="margin-top: 10px; margin-bottom: 10px;">高速公路数据共享平台</h1>
        <p class="subtitle" style="margin-top: 10px; margin-bottom: 10px;">打造智慧高速数据生态圈</p>
      </div>

      <!-- 系统信息部分 -->
      <el-row :gutter="20" class="info-section">
        <!-- 系统简介 -->
        <el-col :sm="24" :lg="12">
          <el-card shadow="hover">
            <div class="system-intro">
              <h2>系统简介</h2>
              <p>高速公路数据共享平台致力于打造全方位的高速公路数据共享生态系统。通过整合车流量、路况、气象、事故及紧急事件等多维数据,为各级管理部门及相关单位提供高效便捷的数据共享服务。</p>
              <p><b>当前版本:</b> <span>v{{ version }}</span></p>
              <div class="feature-list">
                <h3>主要功能</h3>
                <ul>
                  <li><i class="el-icon-data-line"></i> 多维数据整合共享</li>
                  <li><i class="el-icon-refresh"></i> 实时路况数据更新</li>
                  <li><i class="el-icon-pie-chart"></i> 智能数据分析</li>
                  <li><i class="el-icon-monitor"></i> 可视化监控展示</li>
                </ul>
              </div>
            </div>
          </el-card>
        </el-col>

        <!-- 技术架构 -->
        <el-col :sm="24" :lg="12">
          <el-card shadow="hover">
            <div class="tech-stack">
              <h2>技术架构</h2>
              <el-row>
                <el-col :span="12">
                  <h4>后端技术</h4>
                  <ul>
                    <li>SpringBoot</li>
                    <li>Spring Security</li>
                    <li>JWT</li>
                    <li>MyBatis</li>
                    <li>Redis</li>
                    <li>MySQL</li>
                    <li>Kafka</li>
                  </ul>
                </el-col>
                <el-col :span="12">
                  <h4>前端技术</h4>
                  <ul>
                    <li>Vue</li>
                    <li>Element-UI</li>
                    <li>ECharts</li>
                    <li>WebSocket</li>
                    <li>Axios</li>
                  </ul>
                </el-col>
              </el-row>
            </div>
          </el-card>
        </el-col>
      </el-row>

      <!-- 底部功能介绍 -->
      <el-row :gutter="20" class="feature-section">
        <el-col :span="8">
          <el-card shadow="hover">
            <div class="feature-item">
              <i class="el-icon-data-analysis"></i>
              <h3>多维数据整合</h3>
              <p>整合车流量、路况、气象等多维数据，提供全方位的数据共享服务，助力智慧交通建设。</p>
            </div>
          </el-card>
        </el-col>
        <el-col :span="8">
          <el-card shadow="hover">
            <div class="feature-item">
              <i class="el-icon-refresh"></i>
              <h3>实时数据更新</h3>
              <p>支持实时数据采集和更新，确保数据时效性，为决策提供及时可靠的数据支持。</p>
            </div>
          </el-card>
        </el-col>
        <el-col :span="8">
          <el-card shadow="hover">
            <div class="feature-item">
              <i class="el-icon-view"></i>
              <h3>可视化展示</h3>
              <p>采用先进的可视化技术，直观展示数据分析结果，辅助管理决策。</p>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      version: "1.0.0",
      backgroundImage: require("@/assets/images/login-background.jpg")
    }
  },
  computed: {
    backgroundStyle() {
      return {
        backgroundImage: `url(${this.backgroundImage})`,
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        backgroundRepeat: 'no-repeat',
        backgroundAttachment: 'fixed'
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.home {
  min-height: calc(100vh - 84px);
  position: relative;
  background-attachment: fixed;
  background-position: center;
  background-size: cover;
  background-repeat: no-repeat;

  .content-wrapper {
    background: rgba(255, 255, 255, 0.9);
    padding: 20px;
    border-radius: 8px;
    margin: 20px;
  }

  .system-title {
    text-align: center;
    margin-bottom: 40px;

    h1 {
      font-size: 36px;
      color: #303133;
      margin-bottom: 10px;
    }

    .subtitle {
      font-size: 18px;
      color: #606266;
    }
  }

  .info-section {
    margin-bottom: 20px;

    h2 {
      font-size: 24px;
      margin-bottom: 20px;
      color: #303133;
    }

    h3 {
      font-size: 18px;
      margin: 15px 0;
      color: #303133;
    }

    h4 {
      font-size: 18px;
      margin-bottom: 15px;
      color: #303133;
    }

    p {
      line-height: 1.8;
      color: #606266;
      margin-bottom: 15px;
    }

    ul {
      list-style: none;
      padding: 0;

      li {
        line-height: 2;
        color: #606266;

        i {
          margin-right: 8px;
          color: #409EFF;
        }
      }
    }
  }

  .feature-section {
    .feature-item {
      text-align: center;
      padding: 5px;

      i {
        font-size: 48px;
        color: #409EFF;
        margin-bottom: 20px;
      }

      h3 {
        font-size: 20px;
        color: #303133;
        margin-bottom: 15px;
      }

      p {
        color: #606266;
        line-height: 1.6;
      }
    }
  }

  .el-card {
    height: 100%;
    margin-bottom: 20px;

    ::v-deep .el-card__body {
      padding: 20px;
    }
  }
}
</style>

