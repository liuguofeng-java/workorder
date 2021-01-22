<template>
  <div>aaa</div>
</template>

<script>
export default {
  data() {
    return {};
  },
  created() {
    console.log(this);
    this.get('/index').then((res)=>{
      console.log(res);
    })
  },
};
</script>

<style>
</style>
