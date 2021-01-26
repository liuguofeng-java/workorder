import { post, get } from '../utils/request'


export function test() {
    return new Promise((resolve, reject) => {
        get('/test').then(res => {
                console.log(res);
            })
            .then((res) => {
                resolve(res)
            })
            .catch((err) => {
                reject(err)
            })
    })
}