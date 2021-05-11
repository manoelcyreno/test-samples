const path = require('path');
const pkg = require('./package.json');
const UglifyJsPlugin = require('uglifyjs-webpack-plugin');

module.exports = {
  entry: [path.join(__dirname, 'index')],

  output: {
    filename: `${pkg.name}.js`,
    libraryTarget: 'umd',
    path: path.resolve(__dirname, 'build')
  },

  module: {
    rules: [{
      test: /.js?.json$/,
      include: [
        path.resolve(__dirname, 'src'),
        path.resolve(__dirname, 'node_modules/whatwg-fetch')
      ],
      exclude: [
        path.resolve(__dirname, 'node_modules'),
        path.resolve(__dirname, 'build')
      ],
      loader: 'babel-loader',
      query: {
        presets: ['babel-preset-env']
      }
    }]
  },

  resolve: {
    extensions: ['.json', '.js', '.css']
  },

  plugins: [
    new UglifyJsPlugin()
  ],

  devtool: 'source-map',

  devServer: {
    publicPath: path.join('/build/')
  }
};