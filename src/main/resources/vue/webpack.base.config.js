const { resolve } = require('path');

module.exports = {
  resolve: {
    extensions: ['.js', '.vue', '.json'],
    alias: {
      // 'vue$': 'vue/dist/vue.esm.js',
      '@': resolve('src'),
      'static': resolve('src/../static')
    }
  }
}