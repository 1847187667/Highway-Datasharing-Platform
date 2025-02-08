import request from '@/utils/request'

// 查询事故数据管理列表
export function listAccidentdata(query) {
  return request({
    url: '/road/accidentdata/list',//这个URL由控制器类上的@RequestMapping("/road/accidentdata")注解和方法上的@GetMapping("/list")注解组合而成，意为转到/road/accidentdata/list方法
    method: 'get',
    params: query
  })
}

// 查询事故数据管理详细
export function getAccidentdata(id) {
  return request({
    url: '/road/accidentdata/' + id,
    method: 'get'
  })
}

// 新增事故数据管理
export function addAccidentdata(data) {
  return request({
    url: '/road/accidentdata',
    method: 'post',
    data: data
  })
}

// 修改事故数据管理
export function updateAccidentdata(data) {
  return request({
    url: '/road/accidentdata',
    method: 'put',
    data: data
  })
}

// 删除事故数据管理
export function delAccidentdata(id) {
  return request({
    url: '/road/accidentdata/' + id,
    method: 'delete'
  })
}
