<template>
	<div class="Personal">
		<p class="title">PERSONAL</p>
		<el-empty
			class="tologin"
			v-show="!this.isLogin"
			description="请登录"
		></el-empty>
		<div class="per" v-show="this.isLogin">
			<sui-grid>
				<!-- 侧边栏 -->
				<sui-grid-column :width="4">
					<sui-menu fluid vertical tabular>
						<a
							class="siderItem"
							v-for="item in persider"
							:key="item"
							is="sui-menu-item"
							:content="item"
							:active="ispersiderActive(item)"
							@click="select(item)"
						/>
					</sui-menu>
				</sui-grid-column>

				<!-- 右边内容栏 -->
				<sui-grid-column class="percontent" stretched :width="12">
					<sui-segment v-show="false"> </sui-segment>

					<!-- 个人资料  -->
					<sui-segment
						class="contentItem"
						v-show="this.persideractive === this.persider[0]"
					>
						<Perinformation />
					</sui-segment>

					<!-- 历史文案 -->
					<sui-segment
						class="contentItem"
						v-show="this.persideractive === this.persider[1]"
					>
						<History />
					</sui-segment>

					<sui-segment
						class="contentItem"
						v-show="this.persideractive === this.persider[2]"
					>
						<CollectCW />
					</sui-segment>
				</sui-grid-column>
			</sui-grid>
		</div>
	</div>
</template>

<script>
import Perinformation from "./Perinformation.vue";
import CollectCW from "./CollectCW.vue";
import History from "./HistoryCW.vue";
export default {
	name: "Personal",
	// props: ["islogin"],
	components: {
		CollectCW,
		History,
		Perinformation,
	},
	data() {
		return {
			isLogin: false,
			persider: ["个人资料", "历史文案", "文案收藏"],
			persideractive: "个人资料",
			user: {
				userID: "1",
				useremail: "1154130154@qq.com",
				cwuname: "qsh",
				sexValue: "女",
				illegalTime: "0",
				userstatue: "正常",
				userface: "../../../static/img/header/logo.jpg",
			},
		};
	},
	methods: {
		ispersiderActive(name) {
			return this.persideractive === name;
		},
		select(name) {
			this.persideractive = name;
		},
	},
	mounted() {
		// localStorage.setItem("cwuname", "qsh");
		localStorage.removeItem("username");
		// console.log(localStorage);
		// for (let val in this.user) {
		// 	localStorage.setItem(val, this.user[val]);
		// }
		if (localStorage.cwuname) {
			this.isLogin = true;
		} else {
			this.isLogin = false;
		}
		// console.log(localStorage);
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
.per {
	width: 85%;
	margin: 0 auto;
}
.per .percontent {
	background-color: transparent;
}
.per .siderItem {
	position: relative;
}
.per .ui.vertical.tabular.menu a.siderItem.active.item {
	color: rgb(130, 67, 192);
}
.per .contentItem {
	position: absolute;
	width: 100%;
	top: 0;
	height: auto;
	background-color: #fbfbfb;
}
</style>