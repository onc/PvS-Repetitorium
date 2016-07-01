/**
 The MIT License (MIT)

 Copyright (c) 2016  Christian van Onzenoodt

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 **/

var chapterHeader = {
  chapterNode: null,
  slideNumberNode: null
};

/**
 * Updates the dom elements with current chapter and number of slide.
 */
chapterHeader.update = function() {

  var currentChapter = '';
  var currentSlide = Reveal.getCurrentSlide();

  // get current chapter
  var parentElement = currentSlide.parentNode;
  if(parentElement.hasAttribute('data-title')) {
    currentChapter = parentElement.getAttribute('data-title');
  }

  // get currrent slide number
  var currentSlideNumber = Reveal.getIndices().h;

  // update dom nodes
  this.chapterNode.innerHTML = currentChapter;
  this.slideNumberNode.innerHTML = currentSlideNumber;
};

/**
 * Creates all required dom elements and adds them into a header-element.
 */
chapterHeader.initDomNodes = function() {

  // Create Nodes and add them into the DOM
  var headerNode = document.createElement('header');
  headerNode.setAttribute('id', 'chapter-header');

  // current slide
  this.slideNumberNode = document.createElement('p');
  this.slideNumberNode.setAttribute('id', 'slide-number');
  this.slideNumberNode.setAttribute('class', 'reveal');
  headerNode.appendChild(this.slideNumberNode);

  // title of presentation
  var title = document.getElementsByTagName('title')[0].innerHTML;
  var titleNode = document.createElement('p');
  titleNode.setAttribute('id', 'title');
  titleNode.setAttribute('class', 'reveal');
  titleNode.innerHTML = title;
  headerNode.appendChild(titleNode);

  // current chapter
  this.chapterNode = document.createElement('p');
  this.chapterNode.setAttribute('id', 'chapter');
  this.chapterNode.setAttribute('class', 'reveal');
  headerNode.appendChild(this.chapterNode);

  // add to body
  document.getElementsByTagName('body')[0].appendChild(headerNode);
};

/**
 * Initializes the dom-nodes and listens for slideschanged events to update
 * the content.
 */
chapterHeader.init = function() {

  this.initDomNodes();
  this.update();

  // Listen for slide changes and update all the stuff
  Reveal.addEventListener( 'slidechanged', function() {
    this.update();
  }.bind(this));
};
