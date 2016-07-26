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

var chapter = {};

chapter.createListElement = function(chapter) {
  
  var listItem = document.createElement('li');
  var chapterLink = document.createElement('a');
  chapterLink.setAttribute('href', '#/' + chapter.startingSlide);
  chapterLink.innerHTML = chapter.title;

  listItem.appendChild(chapterLink);
  return listItem;
};

chapter.parseChapter = function() {
  
  // all top-level slides a.k.a. chapters
  var chapterElements = document.getElementsByClassName('slides');
  var chapters = [];

  for(var i = 0; i < chapterElements.length; i++) {

    if(chapterElements[i].hasAttribute('data-title')) {
      // get the title of the chapter
      var chapterTitle = chapterElements[i].getAttribute('data-title');
      // get the number of slides in the chapter
      var numberOfSlides = chapterElements[i].childElementCount;

      chapters.push({
        title: chapterTitle,
        numberOfSlides: numberOfSlides
      });
    }
  }

  var startingSlideNumbers = [0];

  // - 1 because this is the start of the last chapter
  for(i = 0; i < chapters.length - 1; i++) {
    // build an array of all slides which are the start of a chapter
    var newNumber = startingSlideNumbers[i] + chapters[i].numberOfSlides;
    startingSlideNumbers.push(newNumber);
  }

  chapters.map(function(chapter, index) {
    chapter.startingSlide = startingSlideNumbers[index];
  });

  return chapters;
};

chapter.toggleTOC = function() {
  var chapterPanel = document.getElementById('chapter-panel');

  if(chapterPanel.hasAttribute('class')) {
    var chapterPanelClass = chapterPanel.getAttribute('class');

    if(chapterPanelClass === 'chapter-panel-hidden') {
      chapterPanel.setAttribute('class', 'chapter-panel-show');
    } else {
      chapterPanel.setAttribute('class', 'chapter-panel-hidden');
    }
  }
};

chapter.init = function() {

  var toggle = document.createElement('div');
  toggle.setAttribute('id', 'toggle-chapter');
  toggle.innerHTML = 'TOC';
  document.getElementsByTagName('body')[0].appendChild(toggle);
  toggle.addEventListener('click', this.toggleTOC, false);

  var chapterListElement = document.createElement('ul');

  var sidePanelElement = document.createElement('div');
  sidePanelElement.setAttribute('id', 'chapter-panel');
  sidePanelElement.setAttribute('class', 'chapter-panel-hidden');
  sidePanelElement.appendChild(chapterListElement);

  document.getElementsByTagName('body')[0].appendChild(sidePanelElement);

  var chapters = this.parseChapter();

  chapters.map(function(chapter, index) {
    chapterListElement.appendChild(this.createListElement(chapter));
  }.bind(this));
};
