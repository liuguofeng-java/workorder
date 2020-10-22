
/**
 * 获取所在城市
 */
export function getCity() {
  return new Promise((resolve, reject) => {
      //实例化城市查询类
    var citysearch = new AMap.CitySearch();
    //自动获取用户IP，返回当前城市
    citysearch.getLocalCity(function (status, result) {
      if (status === "complete" && result.info === "OK") {
        resolve(result);
      }else{
        reject(result);
      }
    });
  })
}

