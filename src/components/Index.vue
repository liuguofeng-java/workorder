<template>
  <div>
    <el-button @click="ajax()" type="primary" :loading="loading">加载中</el-button>
  </div>
</template>

<script>
import { getPersonInfo } from "../api/index";
export default {
  data() {
    return {
      loading: false,
    };
  },
  methods: {
    submit() {
      this.loading = true;
    },
    ajax() {
      this.loading = true;
      this.$get("/comment/music?id=186016&limit=1")
        .then((response) => {
          console.log(response);
          
          this.loading = false;
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style lang="scss" scoped>
.el-row {
  margin-bottom: 20px;
  &:last-child {
    margin-bottom: 0;
  }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>