<template>
  <div class="main-container">
    <el-form
      v-loading="loading"
      :model="ruleForm"
      :rules="rules"
      ref="ruleForm"
      label-width="60px"
    >
      <el-form-item label="用户名:" prop="username">
        <el-input
          type="text"
          v-model="ruleForm.username"
          autocomplete="off"
        ></el-input>
      </el-form-item>
      <el-form-item label="密码:" prop="password">
        <el-input
          type="password"
          v-model="ruleForm.password"
          autocomplete="off"
        ></el-input>
      </el-form-item>
      <el-form-item class="but-container">
        <el-button type="primary" @click="submitForm('ruleForm')"
          >提交</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { register } from "../api/login";
export default {
  data() {
    var validateUserName = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入用户名!"));
      } else if (value.length < 4) {
        callback(new Error("用户名长度不合法!"));
      } else {
        callback();
      }
    };
    var validatePassword = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else if (value.length < 4) {
        callback(new Error("密码长度不合法!"));
      } else {
        callback();
      }
    };
    return {
      loading: false,
      ruleForm: {
        username: "",
        password: "",
      },
      rules: {
        username: [{ validator: validateUserName, trigger: "blur" }],
        password: [{ validator: validatePassword, trigger: "blur" }],
      },
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        //验证失败
        if (!valid) {
          return false;
        }
        //执行登录
        let username = this.ruleForm.username;
        let password = this.ruleForm.password;
        this.loading = true;
        register(username, password)
          //成功获取数据
          .then((res) => {
            if (res.status === "success") {
              this.$message({
                message: res.message,
                type: "success",
              });
              //保持服务器数据
              localStorage.setItem("token", res.data.token);
              localStorage.setItem(
                "userInfo",
                JSON.stringify(res.data.userInfo)
              );
              setTimeout(() => {
                this.$router.replace("/home");
              }, 1000);
            } else {
              this.$alert(res.message, "提示", {
                confirmButtonText: "确定",
              });
            }
            this.loading = false;
          })
          //连接服务器失败时
          .catch((error) => {
            this.$message({
              message: error,
              type: "warning",
            });
            this.loading = false;
          });
      });
    },
  },
};
</script>

<style lang="less">
.main-container {
  width: 500px;
  height:200px;
  border: solid 1px #7777;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  padding: 40px;
}
.but-container {
  text-align: center;
}
</style>