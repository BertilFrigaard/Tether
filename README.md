# Tether
> **Note:** This project is still under active development. Core architecture is in place, but several features are not yet complete.

Tether is a native Android productivity app that gives you softer, smarter control over your phone habits. Instead of hard-blocking apps outright, Tether lets you set up passes — limited exceptions that still require you to pause and think before opening something. It also targets distraction at a more granular level by letting you block specific content within apps, like Shorts, Reels, and TikToks, without blocking the whole app.

The idea is to make it easier to build intentional phone habits without feeling like you're fighting your own device.

<div align="center">
  <img width="200" alt="Screenshot_2026-05-28-16-16-05-02_daccfd32d90aeb4b0e9d6e4faba881e8" src="https://github.com/user-attachments/assets/fe27c254-b75c-468c-a3ae-8e1da1539906" />
<img width="200" alt="Screenshot_2026-05-28-16-17-24-11_daccfd32d90aeb4b0e9d6e4faba881e8" src="https://github.com/user-attachments/assets/2e49a458-eee4-441a-8059-b38a65d87958" />
<img width="200" alt="Screenshot_2026-05-28-16-17-39-89_daccfd32d90aeb4b0e9d6e4faba881e8" src="https://github.com/user-attachments/assets/1626075f-99f4-4a9b-a5f1-8e733a35ab09" />
<img width="200" alt="Screenshot_2026-05-28-16-18-01-87_daccfd32d90aeb4b0e9d6e4faba881e8" src="https://github.com/user-attachments/assets/bb5e95a7-46af-4652-9380-e3f92853c30e" />
<img width="200" alt="Screenshot_2026-05-28-16-18-07-23_daccfd32d90aeb4b0e9d6e4faba881e8" src="https://github.com/user-attachments/assets/f5de032c-f0d8-4e12-8296-223a339d18e9" />
<img width="200" alt="Screenshot_2026-05-28-16-19-14-19_daccfd32d90aeb4b0e9d6e4faba881e8" src="https://github.com/user-attachments/assets/0f8921df-7f27-4546-aba9-1a9927de21ae" />
</div>

---

## How It Works

**1. Block apps softly** — Instead of hard-blocking an app entirely, you set it as restricted. It's still accessible, but only through a pass.

**2. Use passes** — Passes are limited allowances to open a blocked app. When you try to open one, Tether grants access — but optionally only after a configurable delay, giving you time to reconsider before it becomes a reflex.

**3. Block within apps** — For apps you want to keep but find distracting in certain ways, Tether can block specific content types inside them — Shorts on YouTube, Reels on Instagram, the For You feed on TikTok — so you get the utility without the rabbit hole. *(In progress)*

**4. Build awareness** — The combination of friction and intentional access is designed to break unconscious habits, not just lock you out.

---

## Tech Stack

**Mobile (Android)**
- Kotlin with [Jetpack Compose](https://developer.android.com/jetpack/compose) for UI
- Android accessibility services for in-app content detection

---

## Local Setup

Clone the repo and open it in Android Studio. Copy the example env file and fill in any required keys:

```bash
cp .env.example .env
```

Build and run the app on a physical device or emulator:

Use Android Studio to build and run.

---

## Contributing
> **Note:**  I can't promise that this project will continue to be developed for any timeframe. With that said, you are more than welcome to contribute.

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

---

## License

[MIT](LICENSE)
