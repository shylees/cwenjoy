<template>
	<div class="index">
		<Header></Header>
	</div>
</template>

<script>
import Header from "./Header.vue";
export default {
	name: "Index",
	components: {
		Header,
	},
};
</script>

<style scoped>
@import url("../../assets/css/base.css");
.header {
	width: 100vw;
	height: 10vh;
}
</style>