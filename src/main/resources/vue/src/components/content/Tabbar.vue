<template>
	<div class="tabbar">
		<div
			class="cwplay"
			@click="toCwplay()"
			v-bind:class="{ active: cwplayActive }"
		>
			<span>文案广场</span>
		</div>
		<div class="home" @click="toHome()" v-bind:class="{ active: homeActive }">
			<span>主页</span>
		</div>
		<div
			class="personal"
			@click="toPersonal()"
			v-bind:class="{ active: personalActive }"
		>
			<span>个人中心</span>
		</div>
	</div>
</template>

<script>
export default {
	name: "Tabbar",
	data() {
		// data: {
		return {
			tabbarColors: ["red", "#222", "#222"],
			homeActive: true,
			personalActive: false,
			cwplayActive: false,
			userid: 1,
		};
	},
	methods: {
		toHome() {
			this.homeActive = true;
			this.personalActive = false;
			this.cwplayActive = false;
			return this.$router.push({
				path: "/home",
			});
		},
		toPersonal() {
			this.homeActive = false;
			this.personalActive = true;
			this.cwplayActive = false;
			return this.$router.push({
				path: "/personal",
			});
		},
		toCwplay() {
			this.homeActive = false;
			this.personalActive = false;
			this.cwplayActive = true;
			return this.$router.push({
				path: "/cwplay",
			});
		},
		toChangeTabberUserid() {
			this.userid = this.$route.query.id;
		},
	},
};
</script>

<style>
.tabbar {
	display: flex;
	position: absolute;
	bottom: 0;
	right: 0;
	left: 0;
	width: 100%;
	height: 9%;
	/* background-color: antiquewhite; */
	box-shadow: 0 0px 10px 0px rgba(0, 0, 0, 0.08);
}

.tabbar > div {
	flex: 1;
	position: relative;
}

.tabbar > div > span {
	font-size: 0.9rem;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}
.tabbar > div:hover {
	background-color: rgba(230, 230, 250, 0.4);
}

.tabbar > .active {
	background-color: rgba(230, 230, 250, 0.7);
}

.tabbar > .active:hover {
	background-color: rgba(230, 230, 250, 0.7);
}

.tabbar span {
	font-weight: normal;
	font-size: 14px;
}
.tabbar > .active > span {
	color: rgb(130, 67, 192);
	font-size: 16px;
	font-weight: 700;
}
</style>