import request from '@/utils/request'

// 获取数据大屏数据
export function getTrafficDashboardData() {
  return request({
    url: '/system/traffic/datascreen',
    method: 'get'
  })
}

// 获取最新交通状态
export function getLatestTrafficStatus() {
  return request({
    url: '/system/traffic/latest',
    method: 'get'
  })
}