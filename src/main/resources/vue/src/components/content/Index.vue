<template>
	<div class="index">
		<Header></Header>
		<router-view />
		<Tabbar></Tabbar>
	</div>
</template>

<script>
import Header from "./Header.vue";
import Tabbar from "./Tabbar.vue";
export default {
	name: "Index",
	components: {
		Header,
		Tabbar,
	},
};
</script>

<style scoped>
@import "https://cdn.bootcss.com/material-design-icons/3.0.1/iconfont/material-icons.css";
@import url("../../assets/css/base.css");
.header {
	width: 100vw;
	height: 10vh;
}
.index {
	height: 100vh;
	overflow: hidden;
}
.index > div:nth-of-type(2) {
	overflow-y: scroll;
	overflow-x: hidden;
	min-height: 80vh;
}
</style>