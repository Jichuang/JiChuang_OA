/**
 * @license Copyright (c) 2003-2012, CKSource - Frederico Knabben. All rights
 *          reserved. For licensing, see LICENSE.html or
 *          http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function (config) {
    // Define changes to default configuration here.
    // For the complete reference:
    // http://docs.ckeditor.com/#!/api/CKEDITOR.config

    // The toolbar groups arrangement, optimized for two toolbar rows.
    config.toolbarGroups = [
        {
            name: 'clipboard',
            groups: ['clipboard', 'undo']
        },
        {
            name: 'editing',
            groups: ['find', 'selection', 'spellchecker']
        },
        {
            name: 'links'
        },
        {
            name: 'insert'
        },
        {
            name: 'forms'
        },
        {
            name: 'tools'
        },
        {
            name: 'document',
            groups: ['mode', 'document', 'doctools']
        },
        {
            name: 'others'
        },
        '/',
        {
            name: 'basicstyles',
            groups: ['basicstyles', 'cleanup']
        },
        {
            name: 'paragraph',
            groups: ['list', 'indent', 'blocks', 'align']
        },
        {
            name: 'styles'
        },
        {
            name: 'colors'
        },
        {
            name: 'about'
        }
    ];

    config.keystrokes = [
        [CKEDITOR.ALT + 121 /* F10 */, 'toolbarFocus'], // 获取焦点
        [CKEDITOR.ALT + 122 /* F11 */, 'elementsPathFocus'], // 元素焦点
        [CKEDITOR.SHIFT + 121 /* F10 */, 'contextMenu'], // 文本菜单
        [CKEDITOR.CTRL + 90 /* Z */, 'undo'], // 撤销
        [CKEDITOR.CTRL + 89 /* Y */, 'redo'], // 重做
        [CKEDITOR.CTRL + CKEDITOR.SHIFT + 90 /* Z */, 'redo'], //
        [CKEDITOR.CTRL + 76 /* L */, 'link'], // 链接
        [CKEDITOR.CTRL + 66 /* B */, 'bold'], // 粗体
        [CKEDITOR.CTRL + 73 /* I */, 'italic'], // 斜体
        [CKEDITOR.CTRL + 85 /* U */, 'underline'], // 下划线
        [CKEDITOR.ALT + 109 /*-*/, 'toolbarCollapse']
    ]

    // Remove some buttons, provided by the standard plugins, which we don't
    // need to have in the Standard(s) toolbar.
    config.removeButtons = 'Underline,Subscript,Superscript';
    config.tabSpaces = 8;
    config.font_defaultLabel = 'Microsoft Yahei';
    config.fontSize_defaultLabel = '14px';
    config.height = 350;
};
