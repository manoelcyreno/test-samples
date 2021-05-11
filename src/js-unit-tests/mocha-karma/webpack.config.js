const path = require('path');
const projectName = require('./package.json').name;
const isCoverage = process.env.NODE_ENV === 'coverage';

config = {
    entry: './index.js',

    devtool: 'inline-source-map',

    module: {
      loaders: [
        {
          test: /\.js$/,
          loader: 'babel-loader',
          exclude: /('node_modules')/,
          query: {
            plugins: ['transform-decorators-legacy', 'transform-regenerator'],
            presets: ['es2015', 'stage-1']
          }
        }
      ],
    },

    output: {
      filename: `./build/globals/${projectName}.js`,
    },

}

module.exports = config;