//'use strict'
const path = require('path')

module.exports = {
    dev: {
        // Paths
        assetsSubDirectory: 'static',
        assetsPublishPath: '/',
        // 개발용 서버를 위한 proxy 규칙들을 정의
        proxyTable: {},

        // Various Dev Server settings
        host: 'localhost',
        // 개발용 서버의 포트 지정
        port: 8080
    },
    build: {
        // 템플릿이 생성되는 위치를 지정 -> beckend앱의 view파일들을 두는 디렉터리
        // 로컬 파일시스템의 절대경로
        index: path.resolve(_dirname, '../../src/main/resources/templates/home.html'),

        // 앱의 모든 정적 자산들을 포함하는 최상위 디렉터리 경로
        // 로컬 파일시스템의 절대 경로
        assetsRoot: path.resolve(_dirname, '../../src/main/resources/templates'),
        // build.assetsRoot의 하위의 위치하는 웹팩에 의해 처리되는 자원들의 경로
        // 자원들은 ../../src/main/resources/templates/static에 위치하게 됨
        assetsSubDirectory: 'static',
        // build.assetsRoot 자원들에 접근할 수 있는 경로를 설정하는 옵션
        // 대부분의 경우 '/', backend 프레임워크가 정적 자원들에 접근하기 위해 별도의 경로 prefix를 가지고 있다면 수정
        assetsPublicPath: '/',

        // 배포용 빌드에 대한 소스 맵을 생성할 지 여부
        productionSourceMap: true
    }
}