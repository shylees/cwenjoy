<template>
	<div class="Personal">
		<p class="title">PERSONAL</p>
		<el-empty
			class="tologin"
			v-show="!this.isLogin"
			description="请登录"
		></el-empty>

		<UserPre v-show="this.isLogin && this.userID != 1" />
		<ManagerPer v-show="this.isLogin && this.userID == 1" />
	</div>
</template>

<script>
import UserPre from "./UserPer.vue";
import ManagerPer from "./ManagerPer.vue";
export default {
	name: "Personal",

	components: {
		UserPre,
		ManagerPer,
	},
	data() {
		return {
			isLogin: false,
			userID: "",
		};
	},
	methods: {},
	mounted() {
		// localStorage.removeItem("username");
		// for (let val in this.user) {
		// 	localStorage.setItem(val, this.user[val]);
		// }
		if (localStorage.cwuname) {
			this.isLogin = true;
			this.userID = localStorage.userID;
		} else {
			this.isLogin = false;
		}
	},
};
</script>

<style scoped>
@import url("../../assets/css/base.css");
.Personal {
	width: 100%;
	height: 80vh;
	position: relative;
}
.tologin {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}
.tologin .el-empty__description p {
	color: blueviolet;
}
</style>