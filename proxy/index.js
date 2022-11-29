const backendPort = 8080
const frontendPort = 5173
const proxyPort = 8282

const springURL = `http://localhost:${backendPort}/`
const vueUrl = `http://localhost:${frontendPort}/`

const express = require('express');
const { createProxyMiddleware } = require('http-proxy-middleware');
const app = express();

app.use('/api', createProxyMiddleware({ target: springURL, pathRewrite: { '^/api': '/'}, changeOrigin: true }));
app.use('/', createProxyMiddleware({ target: vueUrl, changeOrigin: true }));

app.listen(proxyPort);
