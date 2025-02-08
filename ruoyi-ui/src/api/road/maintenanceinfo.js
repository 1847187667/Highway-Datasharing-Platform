import request from '@/utils/request'

// 查询维护与施工数据管理列表
export function listMaintenanceinfo(query) {
  return request({
    url: '/road/maintenanceinfo/list',
    method: 'get',
    params: query
  })
}

// 查询维护与施工数据管理详细
export function getMaintenanceinfo(id) {
  return request({
    url: '/road/maintenanceinfo/' + id,
    method: 'get'
  })
}

// 新增维护与施工数据管理
export function addMaintenanceinfo(data) {
  return request({
    url: '/road/maintenanceinfo',
    method: 'post',
    data: data
  })
}

// 修改维护与施工数据管理
export function updateMaintenanceinfo(data) {
  return request({
    url: '/road/maintenanceinfo',
    method: 'put',
    data: data
  })
}

// 删除维护与施工数据管理
export function delMaintenanceinfo(id) {
  return request({
    url: '/road/maintenanceinfo/' + id,
    method: 'delete'
  })
}
