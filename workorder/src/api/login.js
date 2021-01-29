import { post, get } from '../utils/request'

/**
 * 获取验证码图片
 */
export function getVerifyCode() {
  return new Promise((resolve, reject) => {
    get('/login/getVerifyCode', {})
      .then((res) => {
        resolve(res);
      })
      .catch((error)=>{
        reject(erro);
      });
  });
}

/**
 * 登录
 * @param {*} username 用户名
 * @param {*} password 密码
 * @param {*} code 验证码
 */
export function register(username, password,code) {
  return new Promise((resolve, reject) => {
    const params = {
      username,
      password,
      code
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
