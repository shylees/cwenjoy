<template>
	<div class="per">
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

				<!-- 警告消息  -->
				<sui-segment
					class="contentItem"
					v-show="this.persideractive === this.persider[0]"
				>
					<Warnmess />
				</sui-segment>

				<!-- 发布公告 -->
				<sui-segment
					class="contentItem"
					v-show="this.persideractive === this.persider[1]"
				>
					<PubNotion />
				</sui-segment>
			</sui-grid-column>
		</sui-grid>
	</div>
</template>

<script>
import Warnmess from "./Warnmess.vue";
import PubNotion from "./PubNotion.vue";
export default {
	name: "ManagerPer",
	components: {
		Warnmess,
		PubNotion,
	},
	data() {
		return {
			isLogin: false,
			persider: ["警告消息", "发布公告"],
			persideractive: "警告消息",
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
};
</script>

<style scoped>
/* @import url("../../assets/css/base.css"); */

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
	/* background-color: #fff; */
}
</style>