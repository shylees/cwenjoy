<template>
	<div class="inform s">
		<!-- <b class="line"></b> -->
		<h2><span>公告</span></h2>
		<div>
			<ul class="informs">
				<li class="InfItem" v-for="item in indata" :key="item.cwid">
					<mu-icon
						left
						value="check_circle"
						color="green"
						v-if="item.ntype == 0"
					></mu-icon>
					<mu-icon
						left
						value="warning"
						color="yellow"
						v-if="item.ntype == 1"
					></mu-icon>
					<span class="intext">{{ item.ncontext }}</span>
					<el-divider class="intime" content-position="right">{{
						new Date(item.ntime).toLocaleString()
					}}</el-divider>
				</li>
			</ul>
		</div>
	</div>
</template>

<script>
import axios from "axios";
export default {
	name: "Inform",
	data() {
		return {
			active1: 0,
			indata: [],
		};
	},
	methods: {
		getallnotion() {
			axios({
				method: "get",
				url: "/queryallnotion",
			})
				.then((res) => {
					console.log(res);
					this.indata = res.data;
				})
				.catch((err) => {
					console.log(err);
				});
		},
	},
	mounted() {
		// this.getallnotion();
		axios({
			method: "get",
			url: "/queryallnotion",
		})
			.then((res) => {
				console.log(res);
				this.indata = res.data;
			})
			.catch((err) => {
				console.log(err);
			});
	},
	updated() {
		// this.getallnotion();
	},
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

.s .informs .InfItem .mu-icon {
	float: left;
}
.s .informs .InfItem .intext {
	font-size: 16px;
	display: block;
	padding: 0 0 0 30px;
	/* padding-right: 20px; */
	height: 1.5rem;
	line-height: 1.5rem;
	margin-bottom: 10px;
	/* margin-right: ; */
	/* float: left; */
	/* width: 80%; */
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