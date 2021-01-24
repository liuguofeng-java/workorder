import { post, get } from '../utils/request'

/**
 * 登录
 * @param {*} username 用户名
 * @param {*} password 密码
 */
export function register (username, password) {
  return new Promise((resolve, reject) => {
    const params = {
      username,
      password
    }
    post('/login/tokenLogin', params)
      .then((res) => {
        resolve(res)
      })
      .catch((err) => {
        reject(err)
      })
  })
}
