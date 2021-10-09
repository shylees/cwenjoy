<template>
	<ul class="centence" :key="key">
		<h2 class="title">文案收藏</h2>
		<li class="CenItem" v-for="item in collectdata" :key="item.cwid">
			<span>{{ item.cwtext }} </span>

			<b
				class="demo-button share showof"
				@click="$toast.success('已复制到剪切板！')"
				color="success"
				><i>分享</i></b
			>
			<b
				class="demo-button deteleCollect showof"
				color="secondary"
				@click="confirmCollected($event)"
				:data-cwid="item.cwid"
				><i>取消收藏</i></b
			>
			<p>
				<b class="time"
					>收藏时间: <br />{{
						new Date(item.ctime).toLocaleString().substring(0, 10)
					}}</b
				>
			</p>
		</li>
	</ul>
</template>

<script>
import axios from "axios";
export default {
	name: "CollectCW",
	data() {
		return {
			collectdata: [],
			cwidlist: [],
			key: Date.parse(new Date()),
		};
	},
	computed: {
		collectdata_dis() {
			return this.collectdata;
		},
	},
	methods: {
		// 收藏
		confirmCollected(e) {
			const cwid = e.currentTarget.dataset.cwid;
			this.$confirm("确定要取消收藏？", "tip", {
				type: "warning",
			}).then(({ result }) => {
				if (result) {
					axios({
						method: "post",
						url: "/deletecollect",
						data: {
							uid: localStorage.uid,
							cwid,
						},
					}).then((res) => {
						if (res.data) {
							this.$toast.success("成功取消收藏！");
							this.update();
						}
					});
				} else {
					this.$toast.message("选择了取消。");
				}
			});
		},
		update() {
			axios({
				method: "get",
				url: "/initcollectbyid",
				params: {
					uid: localStorage.uid,
				},
			})
				.then((res) => {
					this.collectdata = res.data;
					this.cwidlist = [];
					for (let i = 0; i < res.data.length; i++) {
						this.cwidlist.push(res.data[i].cwid);
					}
					localStorage.setItem("cwidlist", this.cwidlist);
				})
				.catch((err) => {
					console.log(err);
				});
			// localStorage.removeItem("cwidlist");
			// this.key = Date.parse(new Date());
		},
	},
	mounted() {
		// 获取所有收藏的文案
		if (localStorage.uid) {
			axios({
				method: "get",
				url: "/initcollectbyid",
				params: {
					uid: localStorage.uid,
				},
			})
				.then((res) => {
					this.collectdata = res.data;
					this.cwidlist = [];
					for (let i = 0; i < res.data.length; i++) {
						this.cwidlist.push(res.data[i].cwid);
					}
					localStorage.setItem("cwidlist", this.cwidlist);
				})
				.catch((err) => {
					console.log(err);
				});
		}
	},
};
</script>

<style scoped>
@import url("../../assets/css/base.css");

/*                           历史文案                  */

.centence {
	width: 100%;
	display: flex;
	flex-wrap: wrap;
	box-sizing: border-box;
	padding: 1% 1%;
	border-radius: 8px;
}
.CenItem {
	position: relative;
	border-right: 1px solid rgb(161, 115, 207);
	border-left: 1px solid rgb(161, 115, 207);
	border-top: 1px solid rgb(161, 115, 207);
	color: #444444;
	width: 100%;
	padding: 15px 15px 20px;
	margin: 0px 8px;
	text-align: left;
}
.CenItem:nth-last-of-type(1) {
	border-bottom: 1px solid rgb(161, 115, 207);
}
.CenItem span {
	font-size: 16px;
	display: block;
	padding-right: 10px;
	width: calc(100% - 10rem);
}

.CenItem:hover .showof {
	opacity: 1;
}
.CenItem .showof {
	opacity: 0;
	top: 0;
	right: 0;
	position: absolute;
	display: inline-block;
	cursor: pointer;
	width: 5rem;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.2);
	text-align: center;
	transition: all 0.3s;
}
.CenItem .showof:hover {
	background-color: rgba(0, 0, 0, 0.5);
}
.CenItem .showof:nth-of-type(1) {
	right: 5rem;
	border-right: 1px solid #ddd;
}
.CenItem .showof i {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.CenItem:hover .time {
	display: none;
}
.CenItem .time {
	display: block;
	width: 5rem;
	position: absolute;
	color: #777;
	font-size: 12px;
	right: 0.9375rem;
	bottom: 0.625rem;
}
</style>