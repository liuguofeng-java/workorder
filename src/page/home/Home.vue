<template>
  <div>
    <header class="header">
      <span class="header_title">饿了么</span>
      <el-link type="Transparent">注册|登录</el-link>
    </header>
    <div class="city_tip">
      <div class="city_title">当前城市位置:</div>
      <div class="city">{{ city }}</div>
    </div>
    <div id="container"></div>
  </div>
</template>

<script>
import { getCity } from "../../api/hoem";
import AMap from 'vue-amap';
export default {
  data() {
    return {
      city: "", //当前城市
    };
  },
  mounted() {
    //实例化城市查询类
    var citysearch = new AMap.CitySearch();
    //自动获取用户IP，返回当前城市
    citysearch.getLocalCity(function (status, result) {
      if (status === "complete" && result.info === "OK") {
        if (result && result.city && result.bounds) {
          var cityinfo = result.city;
          var citybounds = result.bounds;
          document.getElementById("info").innerHTML =
            "您当前所在城市：" + cityinfo;
          //地图显示当前城市
          map.setBounds(citybounds);
        }
      } else {
        document.getElementById("info").innerHTML = result.info;
      }
    });

    //获取当前城市
    getCity().then(
      (res) => {
        console.log(res);
        this.city = res;
      },
      (err) => {
        this.city = "定位不准时，请在城市列表中选择";
      }
    );
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
</style>