<template>
	<div class="inform s">
		<!-- <b class="line"></b> -->
		<h2><span>公告</span></h2>
		<div>
			<ul class="informs">
				<li class="InfItem" v-for="item in this.indata" :key="item.cwid">
					<span class="intext">{{ item.intext }}</span>
					<el-divider class="intime" content-position="right">{{
						item.intime
					}}</el-divider>
				</li>
			</ul>
		</div>
	</div>
</template>

<script>
export default {
	name: "Inform",
	data() {
		return {
			active1: 0,
			indata: [
				{ inid: "1", intext: "系统更新登录功能", intime: "2021/10/5" },
				{
					inid: "2",
					intext: "id为1的用户的文章被举报",
					intime: "2021/10/4",
				},
				{
					inid: "3",
					intext: "id为2的用户被警告一次",
					intime: "2021/10/3  ",
				},
			],
		};
	},
	methods: {},
};
</script>

<style scoped>
@import "../../assets/css/base.css";

.s h2 {
	margin: 2em 0 1em;
	font-size: 1.5em;
	letter-spacing: 1px;
	word-spacing: 6px;
	text-align: center;
}
.s h2 span {
	color: rebeccapurple;
	border-radius: 16px;
}
.s .centences {
	width: 85%;
	margin: 0 auto;
}

.s .informs {
	margin: 0 auto;
	width: 80%;
	display: flex;
	flex-wrap: wrap;
	border: #444 solid 1px;
	box-sizing: border-box;
	padding: 1% 1%;
	border-radius: 8px;
}
.s .informs .InfItem {
	color: #444;
	width: 85%;
	padding: 10px 15px 5px;
	margin: 10px auto;
}
.s .informs .InfItem .intext {
	font-size: 16px;
	display: block;
	padding: 0 0 0 10px;
	/* padding-right: 20px; */
	margin-bottom: 10px;
}

.s .informs .InfItem .intime .el-divider__text {
	color: #aaa;
	font-size: 12px;
	padding: 0 5px;
}
.s .informs .InfItem .el-divider {
	background-color: #cdcdcd;
}
</style>