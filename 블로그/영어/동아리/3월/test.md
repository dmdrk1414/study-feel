Plugin 'honza/vim-snippets' " 코드 조각 모음, ultisnips 플러그인에서 사용하는 코드 조각들의 모음이다.
Plugin 'HTML.zip' " HTML 단축 입력
Plugin 'matchit.zip' " 짝 문자 찾기,
Plugin 'MultipleSearch' " 여러 문자열 동시에 강조
Plugin 'LustyExplorer' " 파일이나 버퍼 선택, 지정된 디렉터리의 파일들이나 현재 열린 버퍼 목록을 윈도우 하단에 짧게 보여준다. 
Plugin 'scrooloose/nerdtree' " 파일 관리자 관리자로 트리 모양으로 파일들을 보여준다.
Plugin 'jiangmiao/auto-pairs' " 짝 문자를 자동으로 입력, 
Plugin 'VisIncr' " 숫자 혹은 문자 자동 증가, 선택된 라인에서 숫자 혹은 문자를 순서대로 증가시키거나 감소시킨다.
Plugin 'visSum.vim' " 숫자 더하기, 선택된 문자열에서 모든 숫자를 더한다.
Plugin 'tpope/vim-abolish' " 대 소문자 포함 영어 단어 변경, 영어 단어 변경할 때 처음 대 문자, 전체 대 소문자, 복수까지 고려해서 변경할 수 있다. 특히 변수명 변경에 편리한데 searchType, search_type, SearchType, search-type 이런 형태로 상호 변환할 수 있다.
Plugin 'xuhdev/SingleCompile' " 하나의 파일 컴파일 후 실행, 
Plugin 'Yggdroot/indentLine' " 들여쓰기 세로 줄 가이드 라인, 코드 들여쓰기 위치에 세로 줄을 만들어서 읽기 좋게 도와준다
Plugin 'vim-jp/vital.vim' " Vim 유틸리티 스크립트, Vim 스크립트를 위한 유틸리티 스크립트
Plugin 'chrisbra/csv.vim' "csv 파일 처리, Vim에서 csv 파일을 처리하기 위한 정말로 많은 기능을 가지고 있다.
Plugin 'mhinz/vim-signify' " 버전 관리 파일 상태 표시,
Plugin 'godlygeek/tabular' " 라인 정렬, 주어진 문자 중심으로 라인을 정렬한다.
Plugin 'plasticboy/vim-markdown' " 마크다운 파일 지원, 마크다운 파일의 문법 강조와 추가 기능을 지원한다
Plugin 'pangloss/vim-simplefold' " 코드 접기, 주어진 문자열을 기준으로 코드 라인들을 접을 수 있다.
Plugin 'terryma/vim-expand-region' " 자동 확장 블럭 지정, 현재 커서 혹은 블럭에서 범위를 넓혀 나가면서 자동으로 블럭을 지정한다.
Plugin 'peterrincker/vim-argumentative' " 함수 인자 위치 변경, 함수 인자나 배열의 항목의 위치를 변경한다.
Plugin 'tommcdo/vim-lion' "  예를 들면 텍스트 블럭 후 gl, 명령으로 ,(comma) 기준으로 정렬할 수 있다.
Plugin 'tpope/vim-fugitive' " Vim에서 git 명령어 사용, git 명령어 wrapper다. 아래는 :Git log를 수행한 모습이다.
Plugin 'dyng/ctrlsf.vim' " 여러 파일 동시에 수정, 
Plugin 'tpope/vim-tbone' "  :Twrite 명령어를 사용했다. vim을 떠나지 않고 일부 명령어를 사용할 수 있다. 
Plugin 'blueyed/vim-diminactive' " 커서가 위치하지 않는 윈도 바탕을 흐리게 만든다
Plugin 'elzr/vim-json' " JSON 파일 보기, JSON 들여 쓰기와 하이라이트를 지원하고 보기 불편한 더블 따옴표를 감춘다.
Plugin 'vim-utils/vim-vertical-move' " 커서를 세로 방향으로 연속으로 이동,
Plugin 'vim-scripts/DrawIt' " 아스키 코드로 라인 그리기, 
Plugin 'Valloric/YouCompleteMe' " 코드 완성 엔진
Plugin 'pangloss/vim-javascript' " 자바스크립트 구문 하이라이트, 
Plugin 'Olical/vim-syntax-expand' "  문자 하나로 자바스크립트 키워드 확장, @, # 와 같은 문자 하나로 this, prototype를 대체하여 입력한다
Plugin 'mvolkmann/vim-js-arrow-function' " 자바스크립트 익명 함수를 화살표 함수로 변경,
Plugin 'vim-syntastic/syntastic' " 구문 체크, 여러 언어의 구문을 체크한다. 
Plugin 'sjl/gundo.vim' " 수정 되돌리기 트리, 이전 수정 상태의 차이점을 보면서 되돌릴 수 있다.
Plugin 'haya14busa/incsearch.vim' " 검색 중인 단어 모두 하이라이트, 
Plugin 'haya14busa/incsearch-easymotion.vim' " 검색 후 하이라이트 결과에 단축 마커 표시,
Plugin 'easymotion/vim-easymotion' " incsearch 사용하기위한 패키지
Plugin 'haya14busa/incsearch-fuzzy.vim' " incsearch 사용하기위한 패키지
Plugin 'tmux-plugins/vim-tmux' " .tmux.conf 파일을 위한 플러그인, .tmux.conf 의 구문 하이라이트 :make 를 사용한 구문 검사등을 지원한다.
Plugin 'leafgarland/typescript-vim' " TypeScript 언어, TypeScript의 구문 하이라이트, 들여쓰기 컴파일 설정
Plugin 'Quramy/vim-js-pretty-template' " JavaScript Template 구문 강조,
Plugin 'jason0x43/vim-js-indent' " JavaScript, TypeScript 들여쓰기,
Plugin 'othree/es.next.syntax.vim' " 미래의 ECMAScript 구문 지원, 



" HTML 단축입력
let g:html_tag_case = 'lowercase'
let g:no_html_tab_mapping = 'yes'

" Plugin 'MultipleSearch' 여러 문자열 동시에 강조
let g:MultipleSearchMaxColors=11
let g:MultipleSearchColorSequence="darkcyan,gray,LightCyan,LightBlue,LightGreen,blue,green,magenta,cyan,gray,brown"
let g:MultipleSearchTextColorSequence="white,DarkRed,black,black,black,white,black,white,red,black,white"
"nmap ,H 0vv\*,
nnoremap  ,H :SearchReset 
nnoremap  ,h :SearchBuffers =expand("")
vnoremap  ,h y:SearchBuffers "

" Plugin 'LustyExplorer'
nmap  ,fD :cd /src/Dropbox/:LustyFilesystemExplorer
nmap  ,fb :cd ~/bin/:LustyFilesystemExplorer
nmap  ,fc :cd ~/code/:LustyFilesystemExplorer
nmap  ,fd :cd ~/download/:LustyFilesystemExplorer
nmap  ,fh :cd ~/:LustyFilesystemExplorer
nmap  ,fj :LustyBufferExplorer
nmap  ,fk :LustyFilesystemExplorer
nmap  ,fl :cd ~/logs/:LustyFilesystemExplorer
nmap  ,fr :cd ~/rc/:LustyFilesystemExplorer
nmap  ,fs :cd ~/src/:LustyFilesystemExplorer
nmap  ,fu :cd ~/.vim/UltiSnips:LustyFilesystemExplorer
nmap  ,fv :cd ~/.vim/bundle/:LustyFilesystemExplorer
nmap  ,fr :Rooter:LustyFilesystemExplorer

" Plugin 'scrooloose/nerdtree'
let g:NERDTreeShowBookmarks = 1
let NERDTreeHijackNetrw = 0
function! GotoTree()
    :NERDTree %:p:h
endfunction
let NERDTreeMapActivateNode=''
let NERDTreeHijackNetrw=1

"  AUTO-PAIRS 짝 문자를 자동으로 입력, 
let g:AutoPairsShortcutToggle = ''
let g:AutoPairsShortcutFastWrap = ''
let g:AutoPairsShortcutJump = ''
let g:AutoPairsMapBS = 0
let g:AutoPairsMapCR = 0
let g:AutoPairsCenterLine = 0
let g:AutoPairsMapSpace = 0

" Plugin 'Yggdroot/indentLine'
let g:indentLine_color_gui = '#385900'
let g:indentLine_color_term = 100
let g:indentLine_char = '¦'
let g:indentLine_first_char = ''
let g:indentLine_showFirstIndentLevel = 0
let g:indentLine_enabled = 0
let g:indentLine_fileTypeExclude = ['help', 'nerdtree', 'text', 'sh']
let g:indentLine_bufNameExclude = ['_.*', 'NERD_tree.*']
let g:indentLine_maxLines = 3000
nnoremap \il :IndentLinesToggle

" Plugin 'godlygeek/tabular' 라인 정렬, 주어진 문자 중심으로 라인을 정렬한다.
inoremap     :call align()a
function! s:align()
let p = '^\s*|\s.*\s|\s*$'
if exists(':Tabularize') && getline('.') =~# '^\s*|' && (getline(line('.')-1) =~# p || getline(line('.')+1) =~# p)
    let column = strlen(substitute(getline('.')[0:col('.')],'[^|]','','g'))
    let position = strlen(matchstr(getline('.')[0:col('.')],'.*|\s*\zs.*'))
    Tabularize/|/l1
    normal! 0
    call search(repeat('[^|]*|',column).'\s\{-\}'.repeat('.',position),'ce',line('.'))
endif
endfunction

" Plugin 'pangloss/vim-simplefold'  코드 접기, 주어진 문자열을 기준으로 코드 라인들을 접을 수 있다.
let g:SimpylFold_docstring_preview=1

" Plugin 'peterrincker/vim-argumentative' " 함수 인자 위치 변경, 함수 인자나 배열의 항목의 위치를 변경한다.
nmap [; Argumentative_Prev
nmap ]; Argumentative_Next
xmap [; Argumentative_XPrev
xmap ]; Argumentative_XNext
nmap <; Argumentative_MoveLeft
nmap >; Argumentative_MoveRight
xmap i; Argumentative_InnerTextObject
xmap a; Argumentative_OuterTextObject
omap i; Argumentative_OpPendingInnerTextObject
omap a; Argumentative_OpPendingOuterTextObject

" Plugin 'dyng/ctrlsf.vim' " 여러 파일 동시에 수정, 
let g:ctrlsf_default_root = 'project+fw'
let g:ctrlsf_ignore_dir = ['bower_components', 'npm_modules']
let g:ctrlsf_indent = 2
nmap     sf CtrlSFPrompt
vmap     sf CtrlSFVwordPath

" Plugin 'blueyed/vim-diminactive' " 커서가 위치하지 않는 윈도 바탕을 흐리게 만든다
let g:diminactive_enable_focus = 1

Plugin 'vim-utils/vim-vertical-move' " 커서를 세로 방향으로 연속으로 이동,
vmap   (vertical_move_down)
vmap   (vertical_move_down)
vmap   (vertical_move_up)

" Plugin 'Valloric/YouCompleteMe' " 코드 완성 엔진
let g:ycm_server_python_interpreter = '/usr/bin/python'
let g:ycm_global_ycm_extra_conf = '~/.ycm_extra_conf.py'
let g:ycm_key_list_select_completion = ['', '']
let g:ycm_key_list_previous_completion = ['', '']
let g:SuperTabDefaultCompletionType = ''
let g:ycm_autoclose_preview_window_after_completion=1
map g :YcmCompleter GoToDefinitionElseDeclaration
let g:ycm_semantic_triggers =  {
\   'c' : ['->', '.'],
\   'objc' : ['->', '.', 're!\[[_a-zA-Z]+\w*\s', 're!^\s*[^\W\d]\w*\s',
\             're!\[.*\]\s'],
\   'ocaml' : ['.', '#'],
\   'cpp,objcpp' : ['->', '.', '::'],
\   'perl' : ['->'],
\   'php' : ['->', '::'],
\   'cs,java,javascript,typescript,d,python,perl6,scala,vb,elixir,go' : ['.'],
\   'ruby' : ['.', '::'],
\   'lua' : ['.', ':'],
\   'erlang' : [':'],
\ }

" Plugin 'pangloss/vim-javascript' " 자바스크립트 구문 하이라이트, 
let g:javascript_plugin_jsdoc = 1
set conceallevel=1
set concealcursor=""
 
autocmd FileType javascript inoremap   @ =syntax_expand#expand("@", "this")
autocmd FileType javascript inoremap   # =syntax_expand#expand("#", ".prototype.")
autocmd FileType javascript inoremap   < =syntax_expand#expand_head("<", "return")
let g:javascript_conceal_function  = "ƒ"
let g:javascript_conceal_prototype = "#"
let g:javascript_conceal_return    = "<"
let g:javascript_conceal_static    = "•"
let g:javascript_conceal_super     = "Ω"
let g:javascript_conceal_this      = "@"
let g:javascript_conceal_undefined = "¿"
let g:javascript_conceal_null      = "ø"
map l :exec &conceallevel ? "set conceallevel=0" : "set conceallevel=1"

" Plugin 'mvolkmann/vim-js-arrow-function' " 자바스크립트 익명 함수를 화살표 함수로 변경,
nmap ar :JsAnonFnToArrowFn
nmap aR :call JsArrowFnBraceToggle()

" Plugin 'vim-syntastic/syntastic' " 구문 체크, 여러 언어의 구문을 체크한다. 
let g:syntastic_html_tidy_ignore_errors=[
    \'proprietary attribute "ng-',
    \'proprietary attribute "chart-',
    \'proprietary attribute "pdk-'
\]
let g:syntastic_always_populate_loc_list = 1
let g:syntastic_check_on_wq = 0
let g:syntastic_loc_list_height = 5
let g:syntastic_javascript_checkers = ['eslint']
let g:syntastic_java_checkers = ['javac', 'checkstyle']
let g:syntastic_json_checkers = ['jsonlint']
let g:syntastic_python_checkers = ['flake8']
let g:syntastic_css_checkers = ['csslint']
let g:syntastic_c_checkers = ['clang_check']
let g:syntastic_html_checkers = ['jshint']
let g:syntastic_typescript_checkers = ['tsuquyomi'] " You shouldn't use 'tsc' checker.
let g:syntastic_error_symbol = '❌ '
let g:syntastic_warning_symbol = '✗ '
let g:syntastic_style_error_symbol = '❓'
let g:syntastic_style_warning_symbol = '❔'
let g:syntastic_java_checkstyle_classpath = '~/checkstyle-7.6-all.jar'
let g:syntastic_java_checkstyle_conf_file = '~/sun_checks.xml'
highlight link SyntasticErrorSign SignColumn
highlight link SyntasticWarningSign SignColumn
highlight link SyntasticStyleErrorSign SignColumn
highlight link SyntasticStyleWarningSign SignColumn

" Plugin 'sjl/gundo.vim' " 수정 되돌리기 트리, 이전 수정 상태의 차이점을 보면서 되돌릴 수 있다.
nnoremap u :GundoToggle

" Plugin 'haya14busa/incsearch.vim' " 검색 중인 단어 모두 하이라이트, 
map /  (incsearch-forward)
map ?  (incsearch-backward)
map g/ (incsearch-stay)
set hlsearch
let g:incsearch#auto_nohlsearch = 1
map N  (incsearch-nohl-N)
map *  (incsearch-nohl-*)
map #  (incsearch-nohl-#)
map g* (incsearch-nohl-g*)
map g# (incsearch-nohl-g#)
 
function! s:config_easyfuzzymotion(...) abort
return extend(copy({
\   'converters': [incsearch#config#fuzzy#converter()],
\   'modules': [incsearch#config#easymotion#module()],
\   'keymap': {"\": '(easymotion)'},
\   'is_expr': 0,
\   'is_stay': 1
\ }), get(a:, 1, {}))
endfunction
noremap  z/ incsearch#go(config_easyfuzzymotion())



