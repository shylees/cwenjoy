<template>
	<div class="Personal">
		<p class="title">PERSONAL</p>
		<el-empty
			class="tologin"
			v-show="!this.isLogin"
			description="请登录"
		></el-empty>

		<UserPre v-show="this.isLogin && this.uid != 1" />
		<ManagerPer v-show="this.isLogin && this.uid == 1" />
		<div class="out">
			<button v-if="this.isLogin" class="signout" @click="signout()">
				退出登录
			</button>
		</div>
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
			uid: "",
		};
	},
	methods: {
		signout() {
			this.$confirm("确定要退出登录？", "tip", {
				type: "warning",
			}).then(({ result }) => {
				if (result) {
					localStorage.removeItem("uid");
					localStorage.removeItem("uname");
					localStorage.removeItem("uemail");
					localStorage.removeItem("upwd");
					localStorage.removeItem("usex");
					localStorage.removeItem("uillegalTime");
					localStorage.removeItem("ustatus");
					localStorage.removeItem("uface");
					this.$toast.success("选择了确定！");
					location.reload();
				} else {
					this.$toast.message("取消修改。");
				}
			});
		},
	},
	mounted() {
		if (localStorage.uname) {
			this.isLogin = true;
			this.uid = localStorage.uid;
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
.out {
	width: 200px;
	height: 40px;
	position: fixed;
	bottom: 11vh;
	right: -100px;
	background: transparent;
	transition: all 0.3s;
}
.out .signout {
	width: 100px;
	height: 40px;
	padding: 5px;
	border: 1px solid darkorchid;
	background-color: rgba(255, 255, 255, 0.25);
}
.out:hover {
	right: 0%;
}
</style>