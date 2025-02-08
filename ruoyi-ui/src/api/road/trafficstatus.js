import request from '@/utils/request'

// 查询交通状态数据管理列表
export function listTrafficstatus(query) {
  return request({
    url: '/road/trafficstatus/list',
    method: 'get',
    params: query
  })
}

// 查询交通状态数据管理详细
export function getTrafficstatus(id) {
  return request({
    url: '/road/trafficstatus/' + id,
    method: 'get'
  })
}

// 新增交通状态数据管理
export function addTrafficstatus(data) {
  return request({
    url: '/road/trafficstatus',
    method: 'post',
    data: data
  })
}

// 修改交通状态数据管理
export function updateTrafficstatus(data) {
  return request({
    url: '/road/trafficstatus',
    method: 'put',
    data: data
  })
}

// 删除交通状态数据管理
export function delTrafficstatus(id) {
  return request({
    url: '/road/trafficstatus/' + id,
    method: 'delete'
  })
}
