<template>
	<div class="cwplay">
		<p class="title">COPYWRITING PLAYGROUNd</p>
		<Centences />
	</div>
</template>

<script>
import axios from "axios";
import Centences from "./Centences.vue";
export default {
	name: "Cwplay",
	components: {
		Centences,
	},
	data() {
		return {};
	},
	methods() {},
};
</script>

<style scoped>
@import url("../../assets/css/base.css");
.cwplay {
	overflow: scroll;
	height: 80vh;
}
</style>