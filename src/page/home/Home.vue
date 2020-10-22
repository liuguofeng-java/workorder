<template>
  <div>
    <header class="header">
      <span class="header_title">饿了么</span>
      <el-link type="Transparent">注册|登录</el-link>
    </header>
    <div class="city_tip">
      <div class="city_title">当前城市位置:</div>
      <div class="city">{{ city }}<span class="iconfont icon-jiantou"></span></div>
    </div>
    
  </div>
</template>

<script>
//import { getCity } from "../../api/hoem";
import {getCity} from '../../api/map'
export default {
  data() {
    return {
      city: "", //当前城市
    };
  },
  mounted() {
    //获取当前城市
    getCity().then((res)=>{
      console.log(res);
      this.city = res.city;
    }).catch((err)=>{
      this.city = '定位失败，请在城市列表中选择';
    });
  },
  methods: {},
  
};
</script>

<style lang="scss" scoped>
.header {
  height: 50px;
  background-color: #3190e8;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 20px;
  color: white;
  margin-bottom: 10px;
}
.city_tip {
  height: 40px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 20px;
  font-size: 12px;
  border-bottom: 0.5px solid #e4e4e4;
}
.city {
    display: flex;
    align-items: center;
    color: #999;
}
</style>