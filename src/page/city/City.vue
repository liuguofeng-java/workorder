<template>
  <div>
    <header class="header">
      <span class="header_title">饿了么</span>
      <el-link type="Transparent">注册|登录</el-link>
    </header>
    <div class="city_tip">
      <div class="city_title">当前城市位置:</div>
      <a class="city">{{ city }}</a>
    </div>

    <div class="city_list">
      <div class="city_title">热门城市</div>
      <ul class="list_hot" style="color: #3190e8">
        <router-link
          v-for="item in cityHot"
          :key="item.area_code"
          @click="hotClick(itme.name)"
          tag="li"
          :to="'/address/' + item.id"
        >
          {{ item.name }}
        </router-link>
      </ul>
    </div>

    <div class="city_list" v-for="(item, key, i) in sortGroupCities" :key="item.id">
      <div class="city_title" v-if="i == 0">{{ key }}(按字母排序)</div>
      <div class="city_title" v-else>{{ key }}</div>
      <ul class="list_hot">
        <router-link
          v-for="i in item"
          :key="i.id"
          tag="li"
          :to="'/address/' + i.id"
        >
          {{ i.name }}
        </router-link>
      </ul>
    </div>

  </div>
</template>

<script>
import { getHotCities, getGroupCities } from "../../api/city";
import { getCity } from "../../api/map";
export default {
  data() {
    return {
      city: "", //当前城市
      cityHot: [], //热门城市
      GroupCities: [], //按字母排序城市
    };
  },
  mounted() {
    //获取当前城市
    getCity()
      .then((res) => {
        this.city = res.city;
      })
      .catch((err) => {
        this.city = "定位失败，请在城市列表中选择";
      });

    //获取热门城市
    getHotCities().then((res) => {
      this.cityHot = res;
    });
    //按组排序城市
    getGroupCities().then((res) => {
      this.GroupCities = res;
    });
  },
  computed: {
    sortGroupCities() {
      let sortobj = {};
      for (let i = 65; i <= 90; i++) {
        if (this.GroupCities[String.fromCharCode(i)]) {
          sortobj[String.fromCharCode(i)] = this.GroupCities[
            String.fromCharCode(i)
          ];
        }
      }
      return sortobj;
    },
  },
  methods: {},
};
</script>

<style lang="scss" scoped>
// 头部
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
//定位城市
.city_tip {
  height: 40px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 20px;
  font-size: 0.55rem;
  color: #666666;
  border-bottom: 2px solid #e4e4e4;
}
.city {
  display: flex;
  align-items: center;
  color: #999;
}
.city::after {
  content: "\e66b";
  font-family: "iconfont";
  font-size: 12px;
}
//热门城市
.city_list {
  border-top: solid 2px #e4e4e4;
  border-bottom: solid 1px #e4e4e4;
  margin-top: 20px;
  color: #666666;
  font-size: 0.55rem;
}
.city_list .city_title {
  height: 30px;
  display: flex;
  align-items: center;
  padding-left: 20px;
  border-bottom: 0.025rem solid #e4e4e4;
}
.list_hot {
  list-style: none;
  width: 100%;
  padding: 0;
  margin: 0;
}
.list_hot li {
  float: left;
  width: 25%;
  height: 2rem;
  line-height: 2rem;
  text-align: center;
  border-bottom: 0.025rem solid #e4e4e4;
  border-right: 0.025rem solid #e4e4e4;
  box-sizing: border-box;
  font-size: 0.9rem;
  overflow: hidden;
  word-break: break-all;
  white-space: nowrap;
  text-overflow: ellipsis;
}
.list_hot::after {
  content: "";
  clear: both;
  display: block;
}
</style>