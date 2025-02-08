import request from '@/utils/request'

// 查询交通管制数据管理列表
export function listTrafficcontrol(query) {
  return request({
    url: '/road/trafficcontrol/list',
    method: 'get',
    params: query
  })
}

// 查询交通管制数据管理详细
export function getTrafficcontrol(id) {
  return request({
    url: '/road/trafficcontrol/' + id,
    method: 'get'
  })
}

// 新增交通管制数据管理
export function addTrafficcontrol(data) {
  return request({
    url: '/road/trafficcontrol',
    method: 'post',
    data: data
  })
}

// 修改交通管制数据管理
export function updateTrafficcontrol(data) {
  return request({
    url: '/road/trafficcontrol',
    method: 'put',
    data: data
  })
}

// 删除交通管制数据管理
export function delTrafficcontrol(id) {
  return request({
    url: '/road/trafficcontrol/' + id,
    method: 'delete'
  })
}
