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
						<div class="button">
							<button v-if="isedit" class="edit" @click="edit()">edit</button>
							<button v-if="issubmit" class="edit" @click="submit()">
								submit
							</button>
						</div>

						<div class="information">
							<div class="facebig">
								<img src="../../../static/img/header/logo.jpg" alt="" />
								<b class="line"></b>
							</div>
							<div class="letters">
								<ul>
									<li>
										<span>userID:</span>
										<span class="userID">{{}}</span>
									</li>
									<li>
										<span>username:</span>
										<span class="nameValue"> {{}} </span>
									</li>
									<li>
										<span>sex:</span>
										<span class="sexValue">{{}}</span>
									</li>
									<li>
										<span>birth:</span>
										<span class="birthValue"> {{}} </span>
									</li>
									<li>
										<span>signature:</span>
										<span class="signatureValue"> {{}} </span>
									</li>
								</ul>
							</div>
						</div>
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
import CollectCW from "./CollectCW.vue";
import History from "./HistoryCW.vue";
export default {
	name: "Personal",
	// props: ["islogin"],
	components: {
		CollectCW,
		History,
	},
	data() {
		return {
			isLogin: false,
			persider: ["个人资料", "历史文案", "文案收藏"],
			persideractive: "个人资料",
			isedit: true,
			issubmit: false,
		};
	},
	methods: {
		ispersiderActive(name) {
			return this.persideractive === name;
		},
		select(name) {
			this.persideractive = name;
		},
		edit() {
			this.isedit = false;
			this.issubmit = true;
			const params = ["nameValue", "sexValue", "birthValue", "signatureValue"];
			toEdit("edit", params);
		},
		submit() {
			this.isedit = true;
			this.issubmit = false;
			const params = ["nameValue", "sexValue", "birthValue", "signatureValue"];
			const values = getChangeValues(params);
			toSubmit(params, values);
		},
	},
	mounted() {
		console.log(localStorage.cwuname);
		// localStorage.setItem("cwuname", "qsh");
		if (localStorage.cwuname) {
			this.isLogin = true;
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

/*                        个人资料                              */
.information {
	display: flex;
	padding: 2% 10%;
	border: rgb(156, 156, 255) dashed 1px;
}
.information > div {
	flex: 1;
	text-align: center;
}
.Personal b.line {
	display: inline-block;
	width: 3px;
	border-right: 2px solid rgb(161, 115, 207);
	position: relative;
	left: 1.6em;
	height: 90%;
	border-radius: 3em/100em;
	top: 50%;
	transform: translate(0, -50%);
	width: 2px;
}

.information > div:nth-of-type(2) {
	flex: 2;
}
.facebig img {
	width: 90%;
	max-width: 12em;

	border-radius: 100em;
}
.letters {
	flex: 2;
}

.letters ul > li {
	display: flex;
}
.letters ul > li > span {
	padding: 1% 2%;
	flex: 1;
	text-align: right;
	font-size: 1.2em;
	color: #111;
}
.letters ul > li > span:nth-of-type(2) {
	flex: 2;
	text-align: left;
	height: 2.1em;
	line-height: 2.1em;
	font-size: 0.9em;
	font-family: "KaTi_GB2312";
	color: #333;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>