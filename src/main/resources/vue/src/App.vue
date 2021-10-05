<template>
	<div id="app">
		<Index></Index>
	</div>
</template>

<script>
import Index from "./components/content/Index.vue";
export default {
	name: "App",
	components: {
		Index,
	},
};
</script>

<style scoped>
#app {
	/* min-width: 722px; */
	/* overflow: scroll; */
}
</style>
