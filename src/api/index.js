//api.js
import service from '../util/http'

export const getPersonInfo = data => {
    return service({url: '/api/dj/program?rid=336355127',method: 'get',data})
};