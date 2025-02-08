import request from '@/utils/request'

// 查询气象数据管理列表
export function listMeteorologicaldata(query) {
  return request({
    url: '/road/meteorologicaldata/list',
    method: 'get',
    params: query
  })
}

// 查询气象数据管理详细
export function getMeteorologicaldata(id) {
  return request({
    url: '/road/meteorologicaldata/' + id,
    method: 'get'
  })
}

// 新增气象数据管理
export function addMeteorologicaldata(data) {
  return request({
    url: '/road/meteorologicaldata',
    method: 'post',
    data: data
  })
}

// 修改气象数据管理
export function updateMeteorologicaldata(data) {
  return request({
    url: '/road/meteorologicaldata',
    method: 'put',
    data: data
  })
}

// 删除气象数据管理
export function delMeteorologicaldata(id) {
  return request({
    url: '/road/meteorologicaldata/' + id,
    method: 'delete'
  })
}


