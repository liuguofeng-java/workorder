import { post, get, patch, put } from '../util/http'

/**
 * 获取当前城市
 */
export const getCity = () => get('/cities', { type: 'guess' });