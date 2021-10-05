<template>
	<div class="home homeP">
		<p class="title">HOME</p>
		<Chart />
		<Inform />
	</div>
</template>

<script>
import Chart from "./Chart.vue";
import Inform from "./Inform.vue";

export default {
	name: "Home",
	components: {
		Chart,
		Inform,
	},
};
</script>

<style scoped>
@import "../../assets/css/base.css";
.homeP {
	height: 80%;
}
.home .chart {
	position: relative;
}

.home .sentencePlayground {
	margin-top: 2em;
}
</style>