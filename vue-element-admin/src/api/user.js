import request from '@/utils/request'

export function login(data) {
  const param = new URLSearchParams()
  param.append('username', data.username)
  param.append('password', data.password)
  return request({
    url: '/login',
    method: 'post',
    data: param
  })
}

export function getInfo(token) {
  return request({
    url: '/info',
    method: 'post'

  })
}

export function logout() {
  return request({
    url: '/logout',
    method: 'post'
  })
}
