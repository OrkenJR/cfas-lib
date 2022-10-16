package kz.iitu.cfaslib.util;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CurrentUserHolder {
    public static final ThreadLocal<String> currentUser = new ThreadLocal<>();
}
