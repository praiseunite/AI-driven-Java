/**
 * AI-Driven Java Programming — Interactive Quiz Engine
 * Handles: multiple choice, true/false, code output prediction
 * Features: instant feedback, scoring, progress tracking, explanations
 */

class QuizEngine {
  constructor(containerId, quizData) {
    this.container = document.getElementById(containerId);
    this.quizData = quizData;
    this.currentQuestion = 0;
    this.score = 0;
    this.answers = [];
    this.answered = new Set();
    this.init();
  }

  init() {
    this.renderQuiz();
    this.updateProgress();
  }

  renderQuiz() {
    this.container.innerHTML = `
      <div class="quiz-header">
        <h2>${this.quizData.title}</h2>
        <p class="quiz-description">${this.quizData.description || ''}</p>
      </div>
      <div class="quiz-progress">
        <div class="progress-bar">
          <div class="progress-fill" id="progressFill" style="width: 0%"></div>
        </div>
        <span class="progress-text" id="progressText">0 / ${this.quizData.questions.length}</span>
      </div>
      <div id="questionsContainer"></div>
      <div id="quizResults" style="display: none;"></div>
      <div class="btn-group" style="justify-content: center; margin-top: var(--space-xl);">
        <button class="btn btn-primary btn-lg" id="submitQuizBtn" onclick="quiz.submitQuiz()" style="display: none;">
          📊 Submit Quiz & See Results
        </button>
      </div>
    `;

    const questionsContainer = document.getElementById('questionsContainer');
    this.quizData.questions.forEach((q, index) => {
      questionsContainer.innerHTML += this.renderQuestion(q, index);
    });
  }

  renderQuestion(question, index) {
    const markers = ['A', 'B', 'C', 'D', 'E', 'F'];
    let questionTextHTML = question.question;

    // Handle code in question
    if (question.code) {
      questionTextHTML += `
        <div class="code-block" style="margin-top: var(--space-md);">
          <div class="code-header">
            <span class="code-lang">Java</span>
          </div>
          <pre><code>${this.escapeHtml(question.code)}</code></pre>
        </div>
      `;
    }

    const optionsHTML = question.options.map((opt, optIndex) => `
      <li class="option" data-question="${index}" data-option="${optIndex}" onclick="quiz.selectOption(${index}, ${optIndex})">
        <span class="option-marker">${markers[optIndex]}</span>
        <span class="option-text">${opt}</span>
      </li>
    `).join('');

    return `
      <div class="quiz-question" id="question-${index}">
        <div class="question-number">Question ${index + 1} of ${this.quizData.questions.length}</div>
        <div class="question-text">${questionTextHTML}</div>
        <ul class="options-list" id="options-${index}">
          ${optionsHTML}
        </ul>
        <div id="explanation-${index}"></div>
      </div>
    `;
  }

  selectOption(questionIndex, optionIndex) {
    if (this.answered.has(questionIndex)) return;

    this.answered.add(questionIndex);
    this.answers[questionIndex] = optionIndex;

    const question = this.quizData.questions[questionIndex];
    const isCorrect = optionIndex === question.correct;

    if (isCorrect) this.score++;

    // Update UI
    const options = document.querySelectorAll(`[data-question="${questionIndex}"]`);
    options.forEach((opt, idx) => {
      opt.classList.add('disabled');
      if (idx === question.correct) {
        opt.classList.add('correct');
      } else if (idx === optionIndex && !isCorrect) {
        opt.classList.add('wrong');
      }
    });

    // Update question card
    const questionCard = document.getElementById(`question-${questionIndex}`);
    questionCard.classList.add(isCorrect ? 'answered-correct' : 'answered-wrong');

    // Show explanation
    const explanationDiv = document.getElementById(`explanation-${questionIndex}`);
    explanationDiv.innerHTML = `
      <div class="explanation ${isCorrect ? 'correct' : 'wrong'}">
        <strong>${isCorrect ? '✅ Correct!' : '❌ Incorrect.'}</strong>
        ${question.explanation}
      </div>
    `;

    this.updateProgress();

    // Show submit button when all answered
    if (this.answered.size === this.quizData.questions.length) {
      document.getElementById('submitQuizBtn').style.display = 'inline-flex';
    }
  }

  updateProgress() {
    const progress = (this.answered.size / this.quizData.questions.length) * 100;
    document.getElementById('progressFill').style.width = `${progress}%`;
    document.getElementById('progressText').textContent =
      `${this.answered.size} / ${this.quizData.questions.length}`;
  }

  submitQuiz() {
    const total = this.quizData.questions.length;
    const percentage = Math.round((this.score / total) * 100);

    let message, messageClass;
    if (percentage >= 90) {
      message = '🌟 Outstanding! You have an excellent understanding!';
      messageClass = 'success';
    } else if (percentage >= 70) {
      message = '👏 Great job! You have a solid grasp of the material.';
      messageClass = 'success';
    } else if (percentage >= 50) {
      message = '📚 Good effort! Review the explanations to strengthen your understanding.';
      messageClass = 'warning';
    } else {
      message = '💪 Keep learning! Review the lesson material and try again.';
      messageClass = 'danger';
    }

    const resultsDiv = document.getElementById('quizResults');
    resultsDiv.style.display = 'block';
    resultsDiv.innerHTML = `
      <div class="quiz-results">
        <div class="score-circle">
          <span class="score-value">${percentage}%</span>
          <span class="score-label">${this.score}/${total} correct</span>
        </div>
        <div class="results-message">${message}</div>
        <div class="btn-group" style="justify-content: center;">
          <button class="btn btn-secondary" onclick="quiz.resetQuiz()">🔄 Retake Quiz</button>
          <a href="lesson.html" class="btn btn-primary">📖 Go to Lesson</a>
        </div>
      </div>
    `;

    document.getElementById('submitQuizBtn').style.display = 'none';

    // Scroll to results
    resultsDiv.scrollIntoView({ behavior: 'smooth', block: 'center' });
  }

  resetQuiz() {
    this.currentQuestion = 0;
    this.score = 0;
    this.answers = [];
    this.answered = new Set();
    this.init();
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }

  escapeHtml(str) {
    const div = document.createElement('div');
    div.textContent = str;
    return div.innerHTML;
  }
}

// ---------- Copy to Clipboard ----------
function copyCode(button) {
  const codeBlock = button.closest('.code-block');
  const code = codeBlock.querySelector('pre code') || codeBlock.querySelector('pre');
  const text = code.textContent;

  navigator.clipboard.writeText(text).then(() => {
    const originalText = button.textContent;
    button.textContent = '✓ Copied!';
    button.classList.add('copied');
    setTimeout(() => {
      button.textContent = originalText;
      button.classList.remove('copied');
    }, 2000);
  }).catch(() => {
    // Fallback
    const textarea = document.createElement('textarea');
    textarea.value = text;
    document.body.appendChild(textarea);
    textarea.select();
    document.execCommand('copy');
    document.body.removeChild(textarea);
    button.textContent = '✓ Copied!';
    button.classList.add('copied');
    setTimeout(() => {
      button.textContent = 'Copy';
      button.classList.remove('copied');
    }, 2000);
  });
}

// ---------- Sidebar Active Tracking ----------
function initSidebarTracking() {
  const sections = document.querySelectorAll('.content-section[id]');
  const sidebarLinks = document.querySelectorAll('.sidebar-nav a');

  if (sections.length === 0 || sidebarLinks.length === 0) return;

  const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        sidebarLinks.forEach(link => link.classList.remove('active'));
        const activeLink = document.querySelector(`.sidebar-nav a[href="#${entry.target.id}"]`);
        if (activeLink) activeLink.classList.add('active');
      }
    });
  }, { threshold: 0.2, rootMargin: '-80px 0px -60% 0px' });

  sections.forEach(section => observer.observe(section));
}

// ---------- Smooth Scroll for Sidebar Links ----------
function initSmoothScroll() {
  document.querySelectorAll('.sidebar-nav a[href^="#"]').forEach(link => {
    link.addEventListener('click', (e) => {
      e.preventDefault();
      const target = document.querySelector(link.getAttribute('href'));
      if (target) {
        target.scrollIntoView({ behavior: 'smooth', block: 'start' });
      }
    });
  });
}

// ---------- Stagger Animation on Scroll ----------
function initScrollAnimations() {
  const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        entry.target.classList.add('animate-fade-in-up');
        observer.unobserve(entry.target);
      }
    });
  }, { threshold: 0.1 });

  document.querySelectorAll('.card, .content-section, .task-card').forEach(el => {
    observer.observe(el);
  });
}

// ---------- Init on DOM Ready ----------
document.addEventListener('DOMContentLoaded', () => {
  initSidebarTracking();
  initSmoothScroll();
  initScrollAnimations();
});

// Global quiz variable
let quiz;
