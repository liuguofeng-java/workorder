import axios from 'axios'
import router from '../router/index'
import Qs from 'qs'

axios.defaults.timeout = 10000
axios.defaults.baseURL = '/api'
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'



//http request 封装请求头拦截器

axios.interceptors.request.use(
  config => {
    config.headers = {
      'Content-Type':'application/x-www-form-urlencoded'
    }
    var token = localStorage.getItem('token');
    if(token != ''){
     config.headers.token = token;
    }
    return config;
  },
  error => {
    return Promise.reject(err);
  }
);


//http response 封装后台返回拦截器

axios.interceptors.response.use(
  response => {
    //当返回信息为未登录或者登录失效的时候重定向为登录页面
    if(response.data.code === 400){
      localStorage.removeItem('token');
      router.push({
        path:"/login",
        querry:{redirect:router.currentRoute.fullPath}//从哪个页面跳转
      })
    }
    return response;
  },
  error => {
    return Promise.reject(error)
  }

)


/**
 * 封装get方法
 * @param url
 * @param data
 * @returns {Promise}
 */

export function get(url, params = {}) {
  return new Promise((resolve, reject) => {
    ajax(url, params, 'get')
      .then((res) => {
        resolve(res)
      })
      .catch((error) => {
        reject(error)
      })
  })
}

/**
 * 封装post请求
 * @param url
 * @param data
 * @returns {Promise}
 */

export function post(url, params = {}) {
  return new Promise((resolve, reject) => {
    ajax(url, params, 'post')
      .then((res) => {
        resolve(res)
      })
      .catch((error) => {
        reject(error)
      })
  })
}

const ajax = (url, params = {}, method) => {
  return new Promise((resolve, reject) => {
    axios({
      method: method,
      url: url,
      data: Qs.stringify(params)
    })
      .then((res) => {
        resolve(res.data)
      })
      .catch((error) => {
        reject(getError(error))
      })
  })
}

/**
 *
 * @param {错误信息} err
 */
function getError(err) {
  if (err && err.response) {
    switch (err.response.status) {
      case 400:
        err.message = '请求错误(400)'
        break
      case 401:
        err.message = '未授权，请重新登录(401)'
        break
      case 403:
        err.message = '拒绝访问(403)'
        break
      case 404:
        err.message = '请求出错(404)'
        break
      case 408:
        err.message = '请求超时(408)'
        break
      case 500:
        err.message = '服务器错误(500)'
        break
      case 501:
        err.message = '服务未实现(501)'
        break
      case 502:
        err.message = '网络错误(502)'
        break
      case 503:
        err.message = '服务不可用(503)'
        break
      case 504:
        err.message = '网络超时(504)'
        break
      case 505:
        err.message = 'HTTP版本不受支持(505)'
        break
      default:
        err.message = `连接出错(${err.response.status})!`
    }
  } else {
    err.message = '连接服务器失败!'
  }
  return err.message
}

