package model;

import com.google.gson.annotations.SerializedName;

public enum ChannelState {
  @SerializedName("opened")
  OPENED,

  @SerializedName("closed")
  CLOSED,

  @SerializedName("settled")
  SETTLED
}
