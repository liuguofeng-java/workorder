import { post, get, patch, put } from '../util/http'


/**
 * 热门城市
 */
export const getHotCities = () => get('/cities', { type: 'hot' });
/**
 * 获取按组排序的城市
 */
export const getGroupCities = () => get('/cities', { type: 'group' });