module.exports = function (grunt) {
    // 项目配置
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        files:'zepto',
        uglify: {
            options: {
                banner: '/*! Andrew Wen <%=files %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
            },
            build: {
                src: 'public/javascripts/<%=files %>.js',
                dest: 'dest/<%= files %>.min.js'
            }
        },
        concat: {
            options: {
                separator: ';'
            },
            dist: {
                src: ['public/javascripts/zepto.js', 'public/javascripts/jquery-2.0.0.js', 'public/javascripts/stickUp.min.js'],
                dest: 'dest/libs.js'
            }
        },
        copy:{
            main:{
                flatten: true,
                src: 'public/javascripts/*.js',
                dest: 'dest/'
            }
        },
        "bower": {
            "install": {
                "options": {
                    "targetDir": "./public/js/lib",
                    "layout": "byComponent",
                    "install": true,
                    "verbose": false,
                    "cleanTargetDir": false
                }
            }
        },
        watch: {
            scripts: {
                files: ['**/*.js'],
                tasks: ['jshint'],
                options: {
                    spawn: false,
                },
            },
        },
        jshint: {
            build: ['test/**/*.js'],
            options:{
                jshintrc:'.jshintrc'
            }
        },
        karma: {
            unit: {
                configFile: 'karma.conf.js',
                autoWatch: true
            }
        }
    });
    // 加载提供"uglify"任务的插件
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-bower-task');
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-contrib-watch');

    grunt.loadNpmTasks('grunt-karma');
    grunt.loadNpmTasks('grunt-css-sprite');



    // 默认任务
    grunt.registerTask('default', ['watch'], function(){
        grunt.log.writeln(' grunt构建完成 ');
    });

}