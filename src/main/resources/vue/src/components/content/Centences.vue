<template>
	<div class="sentencePlayground s">
		<!-- <b class="line"></b> -->
		<h2><span>文 案 广 场</span></h2>
		<div class="centences">
			<mu-container class="centencesType">
				<mu-tabs
					indicator-color="transparent"
					inverse
					color="secondary"
					full-width
					:opacity="0.7"
				>
					<mu-tab @click="getAllcw">全部</mu-tab>
					<mu-tab data-type="0" @click="changeCWdata($event)">生活文艺</mu-tab>
					<mu-tab data-type="1" @click="changeCWdata($event)">阳光向上</mu-tab>
					<mu-tab data-type="2" @click="changeCWdata($event)">悲观文学</mu-tab>
					<mu-tab data-type="3" @click="changeCWdata($event)">听闻爱情</mu-tab>
					<mu-tab data-type="4" @click="changeCWdata($event)">祝福语</mu-tab>
				</mu-tabs>

				<ul class="centence">
					<li
						class="CenItem"
						v-for="item in this.cwdata"
						:key="item.cwid"
						:data-cwid="item.cwid"
					>
						<span>{{ item.cwtext }}</span>
						<p>
							<b class="time" style="">
								发布时间:{{
									new Date(item.cwtime).toLocaleString().substring(0, 10)
								}}
							</b>
							<b class="demo-button" @click="collectcw($event)" color="success"
								>收藏</b
							>
							<b
								class="demo-button"
								@click="$toast.success('已复制到剪切板！')"
								color="success"
								>分享</b
							>
							<b class="demo-button" color="secondary" @click="confirmInform()"
								>举报</b
							>
						</p>
					</li>
				</ul>
			</mu-container>
		</div>
	</div>
</template>

<script>
import axios from "axios";
export default {
	name: "Centences",
	data() {
		return {
			// active1: 0,
			cwdata: [],
			cwidlist: [],
		};
	},
	methods: {
		// 得到不同类型的cw
		changeCWdata(e) {
			console.log(e.currentTarget.dataset.type);
			axios
				.get("/initcwByType", {
					params: {
						cwtype: e.currentTarget.dataset.type,
					},
				})
				.then((res) => {
					this.cwdata = res.data;
					// console.log(this.cwdata);
					// console.log(res);
				})
				.catch((err) => {
					console.log(err);
				});
		},
		// 得到全部cw
		getAllcw() {
			axios
				.get("/initcwAll", {
					headers: { "Access-Control-Allow-Origin": "*" },
				})
				.then((res) => {
					this.cwdata = res.data;
					// console.log(this.cwdata);
					// console.log(res);
				})
				.catch((err) => {
					console.log(err);
				});
		},
		// 收藏
		collectcw(e) {
			if (!localStorage.uid) {
				this.$toast.warning("请先登录");
			} else if (
				this.cwdilist.includes(
					e.currentTarget.parentElement.parentElement.dataset.cwid + ""
				)
			) {
				this.$toast.message("已经在收藏夹了!");
			} else {
				axios({
					method: "post",
					url: "/addcollect",
					data: {
						uid: localStorage.uid,
						cwid: e.currentTarget.parentElement.parentElement.dataset.cwid,
						ctime: Date.parse(new Date()),
						cwtext:
							e.currentTarget.parentElement.previousElementSibling.innerText,
					},
					headers: {
						"content-type": "application/json;",
					},
				})
					.then((res) => {
						console.log(res);
						this.$toast.success("收藏成功！");
					})
					.catch((err) => {
						console.log(err);
					});
			}
		},
		// 举报
		confirmInform() {
			if (!localStorage.uid) {
				this.$toast.warning("请先登录");
			} else {
				this.$confirm("确定要举该文案？", "tip", {
					type: "warning",
				}).then(({ result }) => {
					if (result) {
						this.$toast.success("举报成功！");
					} else {
						this.$toast.message("取消举报。");
					}
				});
			}
		},
	},
	mounted() {
		// 初始化 所有cw
		axios
			.get("/initcwAll", {
				headers: { "Access-Control-Allow-Origin": "*" },
			})
			.then((res) => {
				this.cwdata = res.data;
			})
			.catch((err) => {
				console.log(err);
			});
		this.cwdilist = localStorage.cwidlist.split(",");
	},
};
</script>

<style scoped>
@import "../../assets/css/base.css";
.line {
	position: relative;
	left: 50%;
	transform: translateX(-50%);
	display: block;
	border-top: 2px solid rgb(130, 67, 192);
	border-radius: 1000em/1em;
	width: 90%;
}
.s h2 {
	margin: 0 0 1em 0;
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
.s .centences .centencesType {
	width: 100%;
	display: flex;
	flex-wrap: wrap;
	margin: 0 auto;
	box-sizing: border-box;
}

.s .centences .centence {
	width: 100%;
	display: flex;
	flex-wrap: wrap;
	border: rebeccapurple solid 1px;
	box-sizing: border-box;
	padding: 1% 1%;
	border-radius: 8px;
}
.s .centences .CenItem {
	box-shadow: 0 0 5px 1px rgba(192, 192, 252, 0.678);
	color: #444;
	max-width: 90%;
	min-width: 40%;
	padding: 10px 15px 5px;
	margin: 10px 8px;
	text-align: left;
	border-radius: 14px;
}
.s .centences .CenItem span {
	font-size: 16px;
	display: block;
	padding-right: 20px;
	margin-bottom: 5px;
}
.s .centences .CenItem > p {
	float: right;
}
.s .centences .CenItem > p b {
	font-size: 12px;
	color: #aaa;
	cursor: pointer;
	margin: 0 3px;
}
.s .centences .CenItem > p b:hover {
	color: #000;
}
.s .centences .CenItem > p b.time {
	font-size: 13px;
	cursor: text;
	margin-right: 30px;
}
.s .centences .CenItem > p b.time:hover {
	color: #aaa;
}

div.mu-tab,
div.mu-tab-wrapper,
div.mu-ripple-wrapper {
	border-radius: 8px;
}
div.mu-tab-active {
	background-color: rgba(192, 192, 252, 0.678);
}
.s .centence b > button {
	display: inline-block;
	background-color: none;
	width: none;
	height: none;
}
</style>