/**
 * Created by lixzh on 2/22/17.
 */


var gulp = require('gulp');

var minifycss = require('gulp-minify-css'), // CSS压缩
    uglify = require('gulp-uglify'), // js压缩
    concat = require('gulp-concat'), // 合并文件
    rename = require('gulp-rename'), // 重命名
    clean = require('gulp-clean'),
    less = require('gulp-less'),
    tmodjs = require('gulp-tmod'),
    mkdirp = require('mkdirp'),
    order = require('gulp-order'),
    insert = require('gulp-insert'),
    rev = require('gulp-rev'),
    revCollector = require('gulp-rev-collector'),
    watch = require('gulp-watch'),
    gulpSequence = require('gulp-sequence').use(gulp);


var cleanOff = false;

var distDir = 'src/main/resources/static/dist';

var baseDir = 'src/main/resources/static';

var targetDir = 'target/classes/static/dist';

var getPath = function (path) {
    return baseDir + path;
}

var getDistPath = function (path) {
    return distDir + path;
}

var getTargetPath = function (path) {
    return targetDir + path;
}

gulp.task('clean', function () {
    if (!cleanOff) {
        return gulp.src([getDistPath("")], {
            read: false
        })
            .pipe(clean({
                force: true
            }))
    }
});

gulp.task('copy_font', function () {
    return gulp.src([getPath('/fonts/**')])
        .pipe(gulp.dest(getDistPath('/fonts')))
});

gulp.task('copy_image', function () {
    return gulp.src([getPath('/images/**')])
        .pipe(gulp.dest(getDistPath('/images')))
});

gulp.task('copy_entry', function () {
    return gulp.src([])
        .pipe(gulp.dest(getDistPath("js/")))
});

gulp.task('copy_readme', function () {
    var date = new Date();
    gulp.src([getPath('readme.txt')])
        .pipe(insert.append("V" + date.getFullYear() + (date.getMonth() + 1) + (date.getDate() < 10 ? ("0" + date.getDate()) : date.getDate())))
        .pipe(gulp.dest(getDistPath("js/")));
});


gulp.task('make_lib', function () {
    return gulp.src([
        getPath('/plugins/lib/jquery-2.2.4.min.js'),
        getPath('/plugins/lib/jquery-ui.min.js'),
        getPath('/plugins/bootstrap/bootstrap.min.js'),
        getPath('/plugins/lib/plugins.js'),
        getPath('/js/app.base.js')
    ])
        .pipe(concat("lib.js"))
        .pipe(rename({
            suffix: '.min'
        }))
        .pipe(uglify())
        .pipe(gulp.dest(getDistPath("/js")))
});

gulp.task('make_lib_css', function () {
    return gulp.src([
        getPath('/plugins/bootstrap/bootstrap.css'),
        getPath('/css/base/main.css'),
        getPath('/css/base/style-default.css')
    ])
        .pipe(concat("lib.css"))
        .pipe(rename({
            suffix: '.min'
        }))
        .pipe(minifycss())
        .pipe(gulp.dest(getDistPath('/css')))
});

gulp.task('copy_asset', gulpSequence('copy_font', 'copy_image', 'copy_entry', 'copy_readme'));

gulp.task('build_js', gulpSequence('make_lib'));

gulp.task('build_css', gulpSequence('make_lib_css'));

gulp.task('development', gulpSequence(
    'clean',
    'copy_asset',
    'build_js',
    'build_css'
));

gulp.task('production', gulpSequence(
    'clean',
    'copy_asset',
    'build_js',
    'build_css',
    'revJS',
    'revCSS',
    'revCollectorJsJSP',
    'revCollectorCssJSP',
    'revCollectorCssXML'
));