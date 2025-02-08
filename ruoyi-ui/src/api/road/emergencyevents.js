import request from '@/utils/request'

// 查询紧急事件数据管理列表
export function listEmergencyevents(query) {
  return request({
    url: '/road/emergencyevents/list',
    method: 'get',
    params: query
  })
}

// 查询紧急事件数据管理详细
export function getEmergencyevents(id) {
  return request({
    url: '/road/emergencyevents/' + id,
    method: 'get'
  })
}

// 新增紧急事件数据管理
export function addEmergencyevents(data) {
  return request({
    url: '/road/emergencyevents',
    method: 'post',
    data: data
  })
}

// 修改紧急事件数据管理
export function updateEmergencyevents(data) {
  return request({
    url: '/road/emergencyevents',
    method: 'put',
    data: data
  })
}

// 删除紧急事件数据管理
export function delEmergencyevents(id) {
  return request({
    url: '/road/emergencyevents/' + id,
    method: 'delete'
  })
}
