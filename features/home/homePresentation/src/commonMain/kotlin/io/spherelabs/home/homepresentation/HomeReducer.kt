package io.spherelabs.home.homepresentation

import io.spherelabs.meteor.configs.Change
import io.spherelabs.meteor.extension.effect
import io.spherelabs.meteor.extension.expect
import io.spherelabs.meteor.extension.unexpected
import io.spherelabs.meteor.reducer.Reducer

class HomeReducer : Reducer<HomeState, HomeWish, HomeEffect> {

  override fun reduce(
    currentState: HomeState,
    currentWish: HomeWish,
  ): Change<HomeState, HomeEffect> {
    return when (currentWish) {
      is HomeWish.GetCategories -> {
        expect { currentState.copy(categories = currentWish.categories) }
      }
      is HomeWish.GetPasswordByCategory -> {
        expect { currentState.copy(passwords = currentWish.passwords) }
      }
      is HomeWish.OnPasswordsChanged -> {
        val currentPasswords = currentState.passwords + currentWish.passwords
        expect { currentState.copy(passwords = currentPasswords) }
      }
      is HomeWish.OnCopyClipboardChanged -> {
        effect { HomeEffect.CopyClipboard("Copied '${currentWish.password}'") }
      }
      else -> unexpected { currentState }
    }
  }
}
